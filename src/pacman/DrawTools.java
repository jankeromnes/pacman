package pacman;

import java.awt.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class DrawTools {
	private static int scale = Main.scaleFactor;
	public static void drawSquare(Graphics g,int x,int y) {
		g.fillRect(x*scale, y*scale, scale, scale);
	}
	public static void drawSquare(Graphics g,int x,int y,int xOfs,int yOfs){
	    g.fillRect(x*scale+xOfs,x*scale+yOfs,scale,scale);
    }
    public static void drawSquare(Graphics g,int x,int y,Const.Dir dir,int scale){
	    int[] arr = Const.dirMap.get(dir);
	    drawSquare(g,x,y,arr[0]*scale,arr[1]*scale);
    }
	public static Color randColor(int minCol,int maxCol) {
		int[] colArr = new int[3];
		Random random = new Random();
		int i =0;
		while(i<3) {
			int rand = random.nextInt(maxCol-minCol)+minCol;
			colArr[i] = rand;
			i++;
		}
		return new Color(colArr[0],colArr[1],colArr[2]);
	}
	public static void drawSquare(Graphics g,int x,int y,int size) {
		int sf = scale-size;
		g.fillRect(x*scale+sf/2, y*scale+sf/2, scale-sf, scale-sf);
		}
	public static void drawMap(Graphics g,char[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				char c = map[y][x];
				if(c==' '){
					g.setColor(Color.blue);
					drawSquare(g, x, y);
				}
				if(c=='1') {
					g.setColor(Color.white);
					drawSquare(g,x,y,4);
				}
				if(c=='2') {
					g.setColor(randColor(180,255));
					drawSquare(g,x,y,8);
				}
				if(c=='4') {
					g.setColor(Color.gray);
					drawSquare(g,x,y);
				}
			}
		}
	}
	public static void drawEntity(Graphics g,HashMap<String,Entity> s) {
		for(Entry<String,Entity> e: s.entrySet()) {
			Entity entity = e.getValue();
			switch (e.getKey()) {
				case "pac":
					g.setColor(Color.YELLOW);
					break;
				case "blue":
					g.setColor(Color.CYAN);
					break;
				case "orange":
					g.setColor(Color.ORANGE);
					break;
				case "red":
					g.setColor(Color.RED);
					break;
				case "pink":
					g.setColor(Color.PINK);
					break;
			}
			drawSquare(g, entity.pos.x, entity.pos.y.getVal());
		}
		
	}
}
