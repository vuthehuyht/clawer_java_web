package view;

import java.util.ArrayList;

public class ScrapLinkView {
	public void showLink(ArrayList<String> links) {
		int i = 0;
		for (String link : links) {
			System.out.println(i + " : " + link);
			i++;
		}
	}
}
