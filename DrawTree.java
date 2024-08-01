package drawtree;
import java.util.ArrayList;

public class DrawTree {


	public static void drawtree(int[] parents, String[] names){
		int rootindex=0;
		for (int i=0;i<parents.length;i++){
			if (parents[i]==-1){
				rootindex=i;break;
			}
		}
		ArrayList<String> tree=new ArrayList<String>();;
		tree.add("+-"+names[rootindex]);
		treerecursion(parents,names,tree, rootindex,"  ");
	}
	public static void treerecursion(int[] parents, String[] names, ArrayList<String> tree, int rootindex, String prefix){
		if (parents.length==names.length){
			return;
		}
		else{
			for (int i=0;i<parents.length;i++){
				if (parents[i]==rootindex){
					int multiple=0;
					for (int j=i+1;j<parents.length;j++){
						if (parents[j]==rootindex){
							multiple=1;break;
						}
					}
					String namenode="+-"+names[i];
					String addtotree=prefix+namenode;
					tree.add(addtotree);
					String prefixchild;
					if (multiple==1) {
						prefixchild=prefix+"|"+" ";
					}
					else{
						prefixchild=prefix+"  ";
					}
					treerecursion(parents,names,tree,i,prefixchild);
				}}
			}
			public static void main(String[] args){
				String[] a = {"-1,0,1,1,0,0,5,5"};
				String[] b = {"1,2,3,4,5,6,-1"};
				String[] c = {"1,2,3,4,6,6,-1"};
				String[] d = {"6,2,3,4,5,6,-1"};
				String[] e = {"-1,0,1,1,2,2,3,3,0,8,8,9,9,10,10"};
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
				System.out.println(e);

			}
		}

		//@author hoangdao

