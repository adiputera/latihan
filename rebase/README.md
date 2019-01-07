# latihan git rebase
how to rebase?
1. chekout new branch
2. update branch
3. commit updated
4. (updated master)
5. on branch : git rebase -i master (note -i means interactive, so we can merge multiple commit into one)
6. editor will appear with all commit we've made
7. change pick to s(squash) to all commit but the top one if we want to merge into single commit
8. ctrl+x, y
9. editor will appear, here we can change commit message
10. ctrl+x, y
11. push
12. checkout master
13. git merge branch
14. push
