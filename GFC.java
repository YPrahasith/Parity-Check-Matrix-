import java.util.*; 

class GFC
{ 
	static int m;
	static void codewords(int word[][],int genmat[][],int n) 
	{ 
		int code[][]=new int[1][n];
		int i,j,k;
		for(i=0;i<1;i++)
		{
			for(j=0;j<n;j++)
			{
				code[i][j]=0;
				for(k=0;k<m;k++)
				{
					code[i][j]=code[i][j]+(word[i][k]*genmat[k][j]);
				}
			}
		}
		for(i=0;i<1;i++)
		{
			for(j=0;j<n;j++)
			{
				code[i][j]=code[i][j]%2;
				System.out.print(code[i][j]+" ");
			}
			System.out.println("");
		}	
	} 
	static void binary(int m,int n, int word[][],int genmat[][]) 
	{ 
		if (m<1) 
		{ 
			codewords(word,genmat,n); 
			return; 
		} 
		word[0][m-1] = 0; 
		binary(m-1,n,word,genmat); 
		word[0][m-1] = 1; 
		binary(m-1,n,word,genmat); 
	} 
	public static void main(String args[]) 
	{ 
		int n,i,j; 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows and columns of Generator Matrix:");
		m=sc.nextInt();
		n=sc.nextInt();
		int word[][] = new int[1][m];
		int genmat[][]=new int[m][n]; 
		System.out.println("Enter the elements of generator matrix:");
		
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				genmat[i][j]=sc.nextInt();
			}
		}
		System.out.println("The Code words are:");
		binary(m,n,word,genmat); 
	} 
} 
