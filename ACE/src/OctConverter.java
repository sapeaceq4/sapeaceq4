
public class OctConverter {
	
	public static void main(String[] args) {
		
		String input = "127 150 141 164 163 101 160 160 040 155 145 040 157 156 040 053 064 064 067 065 063 070 061 063 062 065 061 065 040 167 151 164 150 040 171 157 165 162 040 156 141 155 145 040 141 156 144 040 111 040 167 151 154 154 040 162 145 160 154 171 040 167 150 145 156 145 166 145 162 040 160 157 163 163 151 142 154 145 ";
		//int temp=0;
		char ch=0;
		String[] code = input.split(" ");
		String output = "";
		for(int i=0;i<code.length;i++){
			code[i] = "0"+code[i];
		System.out.print(" Code["+i+"]:"+code[i]);
		ch= (char) Integer.parseInt(code[i], 8	);
		System.out.print("; temp:"+ch);
		output+=ch;
		}
		System.out.println("\n"+output);
	}
}
