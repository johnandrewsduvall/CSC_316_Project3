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

    diff_tests;

    echo '-------------------------------';

    echo 'Cleaning up';
    rm -f *.class;

    echo 'Done';
}

function diff_tests {
    echo 'Running diff tests';
    echo '-------------------------------';

    echo 'Running simple';
    java SocialNetwork '../tests/graphs/simple-graph.txt' < '../tests/inputs/simple.txt' > '../tests/outputs/simple.txt';
    echo 'Diffing simple. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/simple.txt' '../tests/outputs/simple.txt' > '../tests/diffs/simple.txt';
    cat '../tests/diffs/simple.txt';
    echo '-------------------------------';

    echo 'Running b1_isfriend';
    java SocialNetwork '../tests/graphs/boundary-graph.txt' < '../tests/inputs/b1_isfriend.txt' > '../tests/outputs/b1_isfriend.txt';
    echo 'Diffing b1_isfriend. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/b1_isfriend.txt' '../tests/outputs/b1_isfriend.txt' > '../tests/diffs/b1_isfriend.txt';
    cat '../tests/diffs/b1_isfriend.txt';
    echo '-------------------------------';

    echo 'Running b2_mutual';
    java SocialNetwork '../tests/graphs/boundary-graph.txt' < '../tests/inputs/b2_mutual.txt' > '../tests/outputs/b2_mutual.txt';
    echo 'Diffing b2_mutual. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/b2_mutual.txt' '../tests/outputs/b2_mutual.txt' > '../tests/diffs/b2_mutual.txt';
    cat '../tests/diffs/b2_mutual.txt';
    echo '-------------------------------';

    echo 'Running b3_relation';
    java SocialNetwork '../tests/graphs/boundary-graph.txt' < '../tests/inputs/b3_relation.txt' > '../tests/outputs/b3_relation.txt';
    echo 'Diffing b3_relation. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/b3_relation.txt' '../tests/outputs/b3_relation.txt' > '../tests/diffs/b3_relation.txt';
    cat '../tests/diffs/b3_relation.txt';
    echo '-------------------------------';

    echo 'Running b4_notconnected';
    java SocialNetwork '../tests/graphs/boundary-graph.txt' < '../tests/inputs/b4_notconnected.txt' > '../tests/outputs/b4_notconnected.txt';
    echo 'Diffing b4_notconnected. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/b4_notconnected.txt' '../tests/outputs/b4_notconnected.txt' > '../tests/diffs/b4_notconnected.txt';
    cat '../tests/diffs/b4_notconnected.txt';
    echo '-------------------------------';

    echo 'Running b5_popular';
    java SocialNetwork '../tests/graphs/boundary-graph.txt' < '../tests/inputs/b5_popular.txt' > '../tests/outputs/b5_popular.txt';
    echo 'Diffing b5_popular. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/b5_popular.txt' '../tests/outputs/b5_popular.txt' > '../tests/diffs/b5_popular.txt';
    cat '../tests/diffs/b5_popular.txt';
    echo '-------------------------------';

    echo 'Running boundary_all';
    java SocialNetwork '../tests/graphs/boundary-graph.txt' < '../tests/inputs/boundary_all.txt' > '../tests/outputs/boundary_all.txt';
    echo 'Diffing boundary_all. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/boundary_all.txt' '../tests/outputs/boundary_all.txt' > '../tests/diffs/boundary_all.txt';
    cat '../tests/diffs/boundary_all.txt';
    echo '-------------------------------';

    echo 'Running c_00125_00250';
    java SocialNetwork '../tests/graphs/n_00125_00250.txt' < '../tests/inputs/c_00125_00250.txt' > '../tests/outputs/c_00125_00250.txt';
    echo 'Diffing c_00125_00250. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00125_00250.txt' '../tests/outputs/c_00125_00250.txt' > '../tests/diffs/c_00125_00250.txt';
    cat '../tests/diffs/c_00125_00250.txt';
    echo '-------------------------------';

    echo 'Running c_00125_00500';
    java SocialNetwork '../tests/graphs/n_00125_00500.txt' < '../tests/inputs/c_00125_00500.txt' > '../tests/outputs/c_00125_00500.txt';
    echo 'Diffing c_00125_00500. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00125_00500.txt' '../tests/outputs/c_00125_00500.txt' > '../tests/diffs/c_00125_00500.txt';
    cat '../tests/diffs/c_00125_00500.txt';
    echo '-------------------------------';

    echo 'Running c_00125_01000';
    java SocialNetwork '../tests/graphs/n_00125_01000.txt' < '../tests/inputs/c_00125_01000.txt' > '../tests/outputs/c_00125_01000.txt';
    echo 'Diffing c_00125_01000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00125_01000.txt' '../tests/outputs/c_00125_01000.txt' > '../tests/diffs/c_00125_01000.txt';
    cat '../tests/diffs/c_00125_01000.txt';
    echo '-------------------------------';

    echo 'Running c_00125_07500';
    java SocialNetwork '../tests/graphs/n_00125_07500.txt' < '../tests/inputs/c_00125_07500.txt' > '../tests/outputs/c_00125_07500.txt';
    echo 'Diffing c_00125_07500. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00125_07500.txt' '../tests/outputs/c_00125_07500.txt' > '../tests/diffs/c_00125_07500.txt';
    cat '../tests/diffs/c_00125_07500.txt';
    echo '-------------------------------';

    echo 'Running c_00250_00500';
    java SocialNetwork '../tests/graphs/n_00250_00500.txt' < '../tests/inputs/c_00250_00500.txt' > '../tests/outputs/c_00250_00500.txt';
    echo 'Diffing c_00250_00500. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00250_00500.txt' '../tests/outputs/c_00250_00500.txt' > '../tests/diffs/c_00250_00500.txt';
    cat '../tests/diffs/c_00250_00500.txt';
    echo '-------------------------------';

    echo 'Running c_00250_01000';
    java SocialNetwork '../tests/graphs/n_00250_01000.txt' < '../tests/inputs/c_00250_01000.txt' > '../tests/outputs/c_00250_01000.txt';
    echo 'Diffing c_00250_01000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00250_01000.txt' '../tests/outputs/c_00250_01000.txt' > '../tests/diffs/c_00250_01000.txt';
    cat '../tests/diffs/c_00250_01000.txt';
    echo '-------------------------------';

    echo 'Running c_00500_01000';
    java SocialNetwork '../tests/graphs/n_00500_01000.txt' < '../tests/inputs/c_00500_01000.txt' > '../tests/outputs/c_00500_01000.txt';
    echo 'Diffing c_00500_01000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00500_01000.txt' '../tests/outputs/c_00500_01000.txt' > '../tests/diffs/c_00500_01000.txt';
    cat '../tests/diffs/c_00500_01000.txt';
    echo '-------------------------------';

    echo 'Running c_00500_02000';
    java SocialNetwork '../tests/graphs/n_00500_02000.txt' < '../tests/inputs/c_00500_02000.txt' > '../tests/outputs/c_00500_02000.txt';
    echo 'Diffing c_00500_02000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_00500_02000.txt' '../tests/outputs/c_00500_02000.txt' > '../tests/diffs/c_00500_02000.txt';
    cat '../tests/diffs/c_00500_02000.txt';
    echo '-------------------------------';

    # Beyond this point, you will exceed the CPU and memory limits for Cloud 9.
    # Should run fine on an actual computer though
    return;

    echo 'Running c_01000_02000';
    java SocialNetwork '../tests/graphs/n_01000_02000.txt' < '../tests/inputs/c_01000_02000.txt' > '../tests/outputs/c_01000_02000.txt';
    echo 'Diffing c_01000_02000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_01000_02000.txt' '../tests/outputs/c_01000_02000.txt' > '../tests/diffs/c_01000_02000.txt';
    cat '../tests/diffs/c_01000_02000.txt';
    echo '-------------------------------';

    echo 'Running c_01000_04000';
    java SocialNetwork '../tests/graphs/n_01000_04000.txt' < '../tests/inputs/c_01000_04000.txt' > '../tests/outputs/c_01000_04000.txt';
    echo 'Diffing c_01000_04000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_01000_04000.txt' '../tests/outputs/c_01000_04000.txt' > '../tests/diffs/c_01000_04000.txt';
    cat '../tests/diffs/c_01000_04000.txt';
    echo '-------------------------------';

    echo 'Running c_02000_04000';
    java SocialNetwork '../tests/graphs/n_02000_04000.txt' < '../tests/inputs/c_02000_04000.txt' > '../tests/outputs/c_02000_04000.txt';
    echo 'Diffing c_02000_04000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_02000_04000.txt' '../tests/outputs/c_02000_04000.txt' > '../tests/diffs/c_02000_04000.txt';
    cat '../tests/diffs/c_02000_04000.txt';
    echo '-------------------------------';

    echo 'Running c_02000_08000';
    java SocialNetwork '../tests/graphs/n_02000_08000.txt' < '../tests/inputs/c_02000_08000.txt' > '../tests/outputs/c_02000_08000.txt';
    echo 'Diffing c_02000_08000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_02000_08000.txt' '../tests/outputs/c_02000_08000.txt' > '../tests/diffs/c_02000_08000.txt';
    cat '../tests/diffs/c_02000_08000.txt';
    echo '-------------------------------';

    echo 'Running c_04000_08000';
    java SocialNetwork '../tests/graphs/n_04000_08000.txt' < '../tests/inputs/c_04000_08000.txt' > '../tests/outputs/c_04000_08000.txt';
    echo 'Diffing c_04000_08000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_04000_08000.txt' '../tests/outputs/c_04000_08000.txt' > '../tests/diffs/c_04000_08000.txt';
    cat '../tests/diffs/c_04000_08000.txt';
    echo '-------------------------------';

    echo 'Running c_04000_16000';
    java SocialNetwork '../tests/graphs/n_04000_16000.txt' < '../tests/inputs/c_04000_16000.txt' > '../tests/outputs/c_04000_16000.txt';
    echo 'Diffing c_04000_16000. Any incorrect output will be diplayed below:';
    diff -b '../tests/expected_outputs/c_04000_16000.txt' '../tests/outputs/c_04000_16000.txt' > '../tests/diffs/c_04000_16000.txt';
    cat '../tests/diffs/c_04000_16000.txt';
    echo '-------------------------------';
}

test

# read -n 1 -s;