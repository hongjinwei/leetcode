package max_points_on_a_line;

/**
 * Max Points on a Line Total Accepted: 37452 Total Submissions: 300213 My Submissions Question Solution 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @https://leetcode.com/problems/max-points-on-a-line/
 * 
 * Input:	[[40,-23],[9,138],[429,115],[50,-17],[-3,80],[-10,33],[5,-21],[-3,80],[-6,-65],[-18,26],[-6,-65],[5,72],[0,77],[-9,86],[10,-2],[-8,85],[21,130],[18,-6],[-18,26],[-1,-15],[10,-2],[8,69],[-4,63],[0,3],[-4,40],[-7,84],[-8,7],[30,154],[16,-5],[6,90],[18,-6],[5,77],[-4,77],[7,-13],[-1,-45],[16,-5],[-9,86],[-16,11],[-7,84],[1,76],[3,77],[10,67],[1,-37],[-10,-81],[4,-11],[-20,13],[-10,77],[6,-17],[-27,2],[-10,-81],[10,-1],[-9,1],[-8,43],[2,2],[2,-21],[3,82],[8,-1],[10,-1],[-9,1],[-12,42],[16,-5],[-5,-61],[20,-7],[9,-35],[10,6],[12,106],[5,-21],[-5,82],[6,71],[-15,34],[-10,87],[-14,-12],[12,106],[-5,82],[-46,-45],[-4,63],[16,-5],[4,1],[-3,-53],[0,-17],[9,98],[-18,26],[-9,86],[2,77],[-2,-49],[1,76],[-3,-38],[-8,7],[-17,-37],[5,72],[10,-37],[-4,-57],[-3,-53],[3,74],[-3,-11],[-8,7],[1,88],[-12,42],[1,-37],[2,77],[-6,77],[5,72],[-4,-57],[-18,-33],[-12,42],[-9,86],[2,77],[-8,77],[-3,77],[9,-42],[16,41],[-29,-37],[0,-41],[-21,18],[-27,-34],[0,77],[3,74],[-7,-69],[-21,18],[27,146],[-20,13],[21,130],[-6,-65],[14,-4],[0,3],[9,-5],[6,-29],[-2,73],[-1,-15],[1,76],[-4,77],[6,-29]]
 * Output:	24
 * Expected:	25
 * why?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

interface Line {
	public boolean isInLine(Point a);
}

/**
 * 一般直线
 * 
 * @author bao
 */
class CommonLine implements Line {

	Point a;
	Point b;

	CommonLine(Point s, Point t) {
		this.a = s;
		this.b = t;
	}

	@Override
	public boolean isInLine(Point p) {
		int y1 = a.y;
		int y2 = b.y;
		int y3 = p.y;
		int x1 = a.x;
		int x2 = b.x;
		int x3 = p.x;

		return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);

	}
}

/**
 * 竖直线
 * 
 * @author bao
 */
class SpecLine implements Line {
	Point a;
	Point b;

	SpecLine(Point s, Point t) {
		this.a = s;
		this.b = t;
	}

	public boolean isInLine(Point p) {
		return a.x == p.x;
	}

}

class LineFactory {

	private static LineFactory instance;

	private LineFactory() {
	};

	public static LineFactory getInstance() {
		if (instance == null) {
			instance = new LineFactory();
		}
		return instance;
	}

	public Line makeLine(Point a, Point b) {
		try {
			if (a.x == b.x) {
				return new SpecLine(a, b);
			} else {
				return new CommonLine(a, b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

class PointMapManager {
	HashMap<Integer, Set<Integer>> pointMap = new HashMap<Integer, Set<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();

	private void put(int i, int j) {
		Set<Integer> s = pointMap.get(i);
		if (s == null) {
			Set<Integer> newSet = new HashSet<Integer>();
			newSet.add(j);
			pointMap.put(i, newSet);
		} else {
			s.add(j);
		}
	}

	public void collect(int i) {
		list.add(i);
	}

	public void batchProcess() {
		if (list.size() <= 1) {
			list.clear();
		} else {
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					put(i, j);
				}
			}
			list.clear();
		}
	}

	public boolean isCounted(int i, int j) {
		Set<Integer> set = pointMap.get(i);
		if (set == null) {
			return false;
		}
		return set.contains(j);
	}
}

public class Solution {

	public boolean isSamePoint(Point a, Point b) {
		return a.x == b.x && a.y == b.y;
	}

	public int maxPoints(Point[] points) {
		LineFactory factory = LineFactory.getInstance();
		PointMapManager manager = new PointMapManager();
		int len = points.length;
		if (len == 0 || len == 1) {
			return len;
		}
		int count;
		int max = 2;
		for (int i = 0; i < points.length; i++) {
			Point a = points[i];
			Line tmpLine = null;
			manager.collect(i);
			count = 1;
			for (int j = i + 1; j < len; j++) {

				Point b = points[j];
				if (manager.isCounted(i, j)) {
					continue;
				} else if (isSamePoint(a, b)) {
					count++;
					if (count > max) {
						max = count;
					}
					manager.collect(j);
					continue;
				} else {
					tmpLine = factory.makeLine(points[i], points[j]);
					count++;
					manager.collect(j);
				}
				for (int k = j + 1; k < len; k++) {
					Point c = points[k];
					if (tmpLine.isInLine(c)) {
						count++;
						manager.collect(k);
					}
				}

				if (count > max) {
					max = count;
				}
				count = 1;
				manager.batchProcess();
				manager.collect(i);
			}

		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(0, 0);
		points[2] = new Point(0, 0);
//		points[3] = new Point(-9, -651);
//		points[4] = new Point(9, 591);

		System.out.println(s.maxPoints(points));
	}
}
