package Task4;

import java.util.Arrays;

public class TransposeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrix [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int ans[][] = new int [matrix[0].length][matrix.length];
        for(int i = 0; i < ans.length; i++)
        {
            for(int j = 0; j < ans[0].length; j++)
            {
                ans[i][j] = matrix[j][i];
            }
        }
        System.out.println(Arrays.deepToString(ans));
	}

}
