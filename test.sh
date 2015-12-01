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

    echo '-------------------------------';

    echo 'Running simple';
    java SocialNetwork '../simple-graph.txt' < '../tests/inputs/simple.txt' > '../tests/outputs/simple.txt';
    echo 'Diffing simple';
    diff -b '../tests/expected_outputs/simple.txt' '../tests/outputs/simple.txt' > '../tests/diffs/simple.txt';

    echo '-------------------------------';

    echo 'Running b1_isfriend';
    java SocialNetwork '../boundary-graph.txt' < '../tests/inputs/b1_isfriend.txt' > '../tests/outputs/b1_isfriend.txt';
    echo 'Diffing b1_isfriend';
    diff -b '../tests/expected_outputs/b1_isfriend.txt' '../tests/outputs/b1_isfriend.txt' > '../tests/diffs/b1_isfriend.txt';

    echo '-------------------------------';

    echo 'Running b2_mutual';
    java SocialNetwork '../boundary-graph.txt' < '../tests/inputs/b2_mutual.txt' > '../tests/outputs/b2_mutual.txt';
    echo 'Diffing b2_mutual';
    diff -b '../tests/expected_outputs/b2_mutual.txt' '../tests/outputs/b2_mutual.txt' > '../tests/diffs/b2_mutual.txt';

    echo '-------------------------------';

    echo 'Running b3_relation';
    java SocialNetwork '../boundary-graph.txt' < '../tests/inputs/b3_relation.txt' > '../tests/outputs/b3_relation.txt';
    echo 'Diffing b3_relation';
    diff -b '../tests/expected_outputs/b3_relation.txt' '../tests/outputs/b3_relation.txt' > '../tests/diffs/b3_relation.txt';

    echo '-------------------------------';

    echo 'Running b4_notconnected';
    java SocialNetwork '../boundary-graph.txt' < '../tests/inputs/b4_notconnected.txt' > '../tests/outputs/b4_notconnected.txt';
    echo 'Diffing b4_notconnected';
    diff -b '../tests/expected_outputs/b4_notconnected.txt' '../tests/outputs/b4_notconnected.txt' > '../tests/diffs/b4_notconnected.txt';

    echo '-------------------------------';

    echo 'Running b5_popular';
    java SocialNetwork '../boundary-graph.txt' < '../tests/inputs/b5_popular.txt' > '../tests/outputs/b5_popular.txt';
    echo 'Diffing b5_popular';
    diff -b '../tests/expected_outputs/b5_popular.txt' '../tests/outputs/b5_popular.txt' > '../tests/diffs/b5_popular.txt';

    echo '-------------------------------';

    echo 'Running boundary-all';
    java SocialNetwork '../boundary-graph.txt' < '../tests/inputs/boundary-all.txt' > '../tests/outputs/boundary-all.txt';
    echo 'Diffing boundary-all';
    diff -b '../tests/expected_outputs/boundary-all.txt' '../tests/outputs/boundary-all.txt' > '../tests/diffs/boundary-all.txt';

    echo '-------------------------------';

    echo 'Cleaning up';
    cd $SRC_FILES_DIR;
    rm -f *.class;

    echo '-------------------------------';

    echo 'Done';
}

test

# read -n 1 -s;