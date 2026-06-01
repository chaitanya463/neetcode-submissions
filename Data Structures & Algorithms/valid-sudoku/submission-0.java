class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap();
        Map<Integer, Set<Character>> columns = new HashMap();
        Map<Integer, Set<Character>> grid = new HashMap();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int cell = board[r][c];
                if (cell == '.') {
                    continue;
                }
                if (rows.getOrDefault(r, new HashSet()).contains(cell)
                    || columns.getOrDefault(c, new HashSet()).contains(cell)
                    || grid.getOrDefault((r/3) * 3+ (c/3), new HashSet()).contains(cell)) {
                        return false;
                    }
                rows.computeIfAbsent(r, k -> new HashSet()).add(cell);
                columns.computeIfAbsent(c, k -> new HashSet()).add(cell);
                grid.computeIfAbsent((r/3) * 3+ (c/3), k -> new HashSet()).add(cell);
            }
        }
        return true;
    }
}
