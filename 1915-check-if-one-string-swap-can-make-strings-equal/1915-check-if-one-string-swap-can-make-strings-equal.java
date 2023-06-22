class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        	    int swap = 0;
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < s1.length() &&  swap < 2 ; i++)
		{
			int x = s1.charAt(i);
			int y = s2.charAt(i);
			
			if (a == y && b == x) {
				a = 0;
				b = 0;
			}
			else if (x != y) {
				swap++;
				a = x;
				b = y;
			}
		}
		return a+b == 0 && swap < 2;
    }
}