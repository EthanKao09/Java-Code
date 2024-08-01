import java.util.Arrays;

public class Dirsort {

	public static void sortDirs (String [] dirs) {
		for (int i = 0; i < dirs.length; i++) {
			int count = -1, locate = 0;
			while (locate >= 0) {
				count++;
				locate = dirs[i].indexOf ("/", locate);
				if (locate != -1) locate++;
			}
			dirs [i] = Character.toString ((char) count) + dirs[i];
		}
		Arrays.sort (dirs);
		for (int i = 0; i < dirs.length; i++) dirs [i] = dirs [i].substring (1);
	}
	public static void main(String[] args) {
		{
			String [] a = {"/", "/usr/", "/usr/local/", "/usr/local/bin/", "/games/", "/games/snake/", "/homework/", "/temp/downloads/"};
			sortDirs (a);
			for (int i = 0; i < a.length; i++) System.out.print (a[i]+ "  ");
			System.out.println ();
		}
		{
			String[]  a = {"/usr/", "/usr/local/", "/bin/", "/usr/local/bin/", "/usr/bin/", "/bin/local/", "/bin/local/"};
			sortDirs (a);
			for (int i = 0; i < a.length; i++) System.out.print (a[i]+ "  ");
			System.out.println ();
		}
		{
			String[]  a = {"/", "/a/", "/b/", "/c/", "/d/", "/e/", "/f/", "/g/"};
			sortDirs (a);
			for (int i = 0; i < a.length; i++) System.out.print (a[i]+ "  ");
			System.out.println ();
		}
		{
			String[]  a = {"/", "/a/", "/b/", "/c/", "/d/", "/e/", "/f/", "/g/", "/a/a/", "/b/g/c/", "/g/f/"};
			sortDirs (a);
			for (int i = 0; i < a.length; i++) System.out.print (a[i]+ "  ");
			System.out.println ();
		}
		{
			String[]  a = {"/a/b/c/d/e/f/g/h/i/j/k/l/m/n/", "/o/p/q/r/s/t/u/v/w/x/y/z/"};
			sortDirs (a);
			for (int i = 0; i < a.length; i++) System.out.print (a[i]+ "  ");
			System.out.println ();
		}
		{
			String[]  a = {"/a/b/", "/ab/cd/", "/c/d/", "/a/b/c/", "/ab/c/d/", "/a/bc/d/", "/a/b/cd/"};
			sortDirs (a);
			for (int i = 0; i < a.length; i++) System.out.print (a[i]+ "  ");
			System.out.println ();
		}
	}
}

