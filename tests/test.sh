function test {
    local MAIN_PROGRAM='SocialNetwork';
    local SRC_FILES_DIR='src';
    local BACK_SRC_FILES_DIR='../';
    local INPUT_FILES_DIR='tests/inputs';
    local BACK_INPUT_FILES_DIR='../../';
    local EXCPECTED_OUTPUT_FILES_DIR='tests/expected_outputs';
    local BACK_EXCPECTED_OUTPUT_FILES_DIR='../../';
    local OUTPUT_FILES_DIR='tests/outputs';
    local BACK_OUTPUT_FILES_DIR='../../';

    echo 'Cleaning up';
    cd $SRC_FILES_DIR;
    rm -f *.class;
    cd $BACK_SRC_FILES_DIR;

    cd $OUTPUT_FILES_DIR;
    rm -f *.txt;
    cd $BACK_OUTPUT_FILES_DIR;

    echo '-------------------------------';

    echo 'Building source';
    cd $SRC_FILES_DIR;
    javac *.java;
    if [ ! -f $MAIN_PROGRAM'.class' ]
    then
        echo 'Build failed';
        rm -f *.class;
        return;
    fi
    cd $BACK_SRC_FILES_DIR;

    echo '-------------------------------';

    echo 'Running test executables...';
    cd $SRC_FILES_DIR;
    for filename in *Tester.class
    do
        filenameWithoutExt=${filename:0:(-6)};
        echo 'Executing' $filenameWithoutExt;
        java $filenameWithoutExt 'go';
    done
    cd $BACK_SRC_FILES_DIR;

    echo '-------------------------------';

    echo 'Running diff tests';
    cd $SRC_FILES_DIR;
    local inputDirLen=${#INPUT_FILES_DIR};
    local backSrcDirLen=${#BACK_SRC_FILES_DIR};
    inputDirLen=$((inputDirLen+backSrcDirLen+1));
    for inputFileName in $BACK_SRC_FILES_DIR$INPUT_FILES_DIR/*.txt
    do
        fileName=${inputFileName:inputDirLen};
        local outputFileName=$BACK_SRC_FILES_DIR$OUTPUT_FILES_DIR'/'$fileName;
        echo 'Executing against' $fileName;
        java $MAIN_PROGRAM < $inputFileName > $outputFileName;
        echo 'Diffing expected vs actual for:' $fileName '. Any differences are shown below:';
        local expectedOutputFileName=$BACK_SRC_FILES_DIR$EXCPECTED_OUTPUT_FILES_DIR'/'$fileName;
        diff -b $expectedOutputFileName $outputFileName;
    done

    echo '-------------------------------';

    rm -f *.class;
    echo 'Done';
}

test

# read -n 1 -s;