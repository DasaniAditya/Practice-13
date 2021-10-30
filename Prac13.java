//Majority-Element II

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MAX_VALUE;
        int ele2 = Integer.MAX_VALUE;
        
        for(int i : nums) {
            if(ele1 == i) {
                count1++;
            } else if(ele2 == i) {
                count2++;
            } else if(count1 == 0) {
                count1++;
                ele1 = i;
            } else if(count2 == 0) {
                count2++;
                ele2 = i;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        
        for(int i : nums) {
            if(i == ele1) {
                count1++;
            } else if(i == ele2) {
                count2++;
            }
        }
        if(count1 > nums.length / 3) {
            result.add(ele1);
        }
        if(count2 > nums.length / 3) {
            result.add(ele2);
        }
        return result;
    }
}


//Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result;
        if(board.length == 0 || board == null) {
            return true;
        }
        
        for(int i = 0 ; i < board.length; i++) {
            int[] freq = new int[10];
            for(int j = 0 ; j < board.length; j++) {
                if(board[i][j] != '.') {
                    freq[board[i][j] - '0']++;
                }
            }
            if(!checkValidity(freq)) {
                return false;
            }
        }
        
        for(int j = 0; j < board[0].length; j++) {
            int[] freq = new int[10];
            for(int i = 0 ; i < board.length; i++) {
                if(board[i][j] != '.') {
                    freq[board[i][j] - '0']++;
                }
            }
            if(!checkValidity(freq)) {
                return false;
            }
        }
        return checkBoxes(board,0,2,0,2)&&checkBoxes(board,0,2,3,5)&&checkBoxes(board,0,2,6,8)&&
               checkBoxes(board,3,5,0,2)&&checkBoxes(board,3,5,3,5)&&checkBoxes(board,3,5,6,8)&&
               checkBoxes(board,6,8,0,2)&&checkBoxes(board,6,8,3,5)&&checkBoxes(board,6,8,6,8);

    }
    
    public boolean checkValidity(int[] freq) {
        for(int i = 0 ; i < freq.length; i++) {
            if(freq[i] >1) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkBoxes(char[][] board, int rowstart,int rowend,int colstart,int colend) {
        int[] freq = new int[10];
        for(int i = rowstart; i <= rowend;i++) {
            for(int j = colstart; j <= colend; j++) {
                if(board[i][j] != '.') {
                    freq[board[i][j] - '0']++;
                }
            }
        }
        for(int i = 0 ; i < freq.length; i++) {
            if(freq[i] > 1) {
                return false;
            }
        }
        //System.out.println(Arrays.toString(freq));
        return true;
    }
}