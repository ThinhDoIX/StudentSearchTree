import java.util.ArrayList;
import java.util.Random;

public class BST {

	private Node parent;
	
	private class Node {
		private Integer studentId;
		private String name;
		private String dateOfBirth;
		private Double avgGrade;
		private int tc;

		private Node left, right;
		private int size;

		public Node(Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc, int size) {
			this.studentId = studentId;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.avgGrade = avgGrade;
			this.tc = tc;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Student[id: " + studentId + ", hoTen: " + name + ", NgaySinh: " + dateOfBirth + ", DTB tich luy: " + avgGrade + ", So tin chi: " + tc + "]";
		}
	}


	// create empty tree
	public BST() {
		parent = null;
	}

	

	public void printNode(Node x) {
		System.out.print(x.toString());
		System.out.println();

		System.out.print(x.left.toString());
		System.out.println();

		System.out.print(x.right.toString());
		System.out.println();		
	}

	public int size() {
		return size(parent);
	}

	private int size(Node x) {
		if(x==null) return 0;
		else return x.size;
	}

	private Node min(Node x) {
		if(x.left == null)
			return x;
		else
			return min(x.left);
	}

	private Node max(Node x) {
		if(x.right == null)
			return x;
		else 
			return max(x.right);
	}

	public void findMinMax() {
		
		// min Node:
		Node x = min(parent);
		// max Node:
		Node y = max(parent);
		
		System.out.print("Sinh vien co mssv nho nhat: ");
		System.out.println(x.toString());
	
		System.out.print("Sinh vien co mssv lon nhat: ");
		System.out.println(y.toString());
		
	}

	public void put(Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc) {
		parent = put(parent, studentId, name, dateOfBirth, avgGrade, tc);
	}


	private Node put(Node x, Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc) {
		if(x == null) 
			return new Node(studentId, name, dateOfBirth, avgGrade, tc, 1);

		int cmp = studentId.compareTo(x.studentId);
		if(cmp < 0) 
			x.left = put(x.left, studentId, name, dateOfBirth, avgGrade, tc);
		else if (cmp > 0) 
			x.right = put(x.right, studentId, name, dateOfBirth, avgGrade, tc);
		else {
			x.studentId = studentId;
			x.name = name;
			x.dateOfBirth = dateOfBirth;
			x.avgGrade = avgGrade;
			x.tc = tc;
		}
			
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}

	// Thuat toan dung cay lech phai
	public void putRight(Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc) {
		parent = putRight(parent, studentId, name, dateOfBirth, avgGrade, tc);
	}

	private Node putNodeRight(Node x, Node y) {
		y.right = x;
		return y;
	}

	private Node putRight(Node x, Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc) {
		if(x == null) 
			return new Node(studentId, name, dateOfBirth, avgGrade, tc, 1);

		int cmp = studentId.compareTo(x.studentId);
		if(cmp > 0) {
			x.right = putRight(x.right, studentId, name, dateOfBirth, avgGrade, tc);
		} else if(cmp < 0) {
			Node y = new Node(studentId, name, dateOfBirth, avgGrade, tc, 1);
			return putNodeRight(x, y);
		} else {
			x.studentId = studentId;
			x.name = name;
			x.dateOfBirth = dateOfBirth;
			x.avgGrade = avgGrade;
			x.tc = tc;
		}
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}

	// In cay lech phai
	public void printRight() {
		printRight(parent);
	}

	private void printRight(Node x) {
		if(x != null) {
			System.out.println("Student[id: " + x.studentId + ", hoTen: " + x.name + ", NgaySinh: " + x.dateOfBirth + ", DTB tich luy: " + x.avgGrade + ", So tin chi: " + x.tc + "]");
			printRight(x.right);
		}
	}

	// Thuat toan dung cay lech trai
	public void putLeft(Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc) {
		parent = putLeft(parent, studentId, name, dateOfBirth, avgGrade, tc);
	}

	private Node putNodeLeft(Node x, Node y) {
		y.left = x;
		return y;
	}

	private Node putLeft(Node x, Integer studentId, String name, String dateOfBirth, Double avgGrade, int tc) {
		if(x == null) 
			return new Node(studentId, name, dateOfBirth, avgGrade, tc, 1);

		int cmp = studentId.compareTo(x.studentId);
		if(cmp < 0) {
			x.left = putLeft(x.left, studentId, name, dateOfBirth, avgGrade, tc);
		} else if(cmp > 0) {
			Node y = new Node(studentId, name, dateOfBirth, avgGrade, tc, 1);
			return putNodeLeft(x, y);
		} else {
			x.studentId = studentId;
			x.name = name;
			x.dateOfBirth = dateOfBirth;
			x.avgGrade = avgGrade;
			x.tc = tc;
		}

		x.size = 1 + size(x.right) + size(x.left);
		return x;
	}

	// In cay lech trai
	public void printLeft() {
		printLeft(parent);
	}

	private void printLeft(Node x) {
		if(x != null) {
			System.out.println("Student[id: " + x.studentId + ", hoTen: " + x.name + ", NgaySinh: " + x.dateOfBirth + ", DTB tich luy: " + x.avgGrade + ", So tin chi: " + x.tc + "]");
			printLeft(x.left);
		}
	}

	// Them vao danh sach cac Node:
	public void putList(ArrayList<Node> student) {
		for(Node x: student) {
			parent = put(parent, x.studentId, x.name, x.dateOfBirth, x.avgGrade, x.tc);
		}
	}

	// GIAI THUAT TAO CAY RONG | TAO CAY NGAU NHIEN | TAO CAY LECH TRAI | TAO CAY LECH PHAI
	public void createTree_Empty() {
		parent = null;
	}

	public void createTree_Random() {
		/*Integer[] id = new Integer[7];
		String[] name = new String[7];
		String[] dateOfBirth = new String[7];
		Double[] average = new Double[7];
		int[] tc = new int[7];

		id[0] = 123; name[0] = "Nguyen Thi Diep"; dateOfBirth[0] = "24/02/1998"; average[0] = 8.0; tc[0] = 70;
		id[1] = 572; name[1] = "Nguyen Van Danh"; dateOfBirth[1] = "25/03/1999"; average[1] = 8.75; tc[1] = 75;
		id[2] = 120; name[2] = "Pham Thi Chau"; dateOfBirth[2] = "26/05/1999"; average[2] = 6.25; tc[2] = 60;
		id[3] = 121; name[3] = "Do Van Thanh"; dateOfBirth[3] = "03/07/1997"; average[3] = 8.0; tc[3] = 80;
		id[4] = 122; name[4] = "Tran Thi Duyen"; dateOfBirth[4] = "28/12/1999"; average[4] = 9.5; tc[4] = 100;
		id[5] = 550; name[5] = "Nguyen Minh Tu"; dateOfBirth[5] = "29/10/1996"; average[5] = 8.75; tc[5] = 95;
		id[6] = 590; name[6] = "Pham Van Chanh"; dateOfBirth[6] = "01/01/1998"; average[6] = 7.0; tc[6] = 65;

		ArrayList<Node> student = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			student.add(new Node(id[i], name[i], dateOfBirth[i], average[i], tc[i], 1));
		}
		putList(student);*/
		Random rd = new Random();
		// Create random Node from 5 to 9
		int noNode = rd.nextInt(5) + 5;
		// Create random Integer from 100 to 999 with noNode times
		for(int i = 0; i < noNode; i++) {
			Integer studentId = rd.nextInt(900) + 100;
			put(studentId, "", "", 0.0, 0);
		}

	}

	// LEFT - NODE - RIGHT
	private void lnr(Node x) {
		if(x != null) {
			lnr(x.left);
			System.out.println(x.toString());
			lnr(x.right);
		}
	}

	public void lnr() {
		lnr(parent);
	}

	// LEFT - RIGHT - NODE
	private void lrn(Node x) {
		if(x != null) {
			lrn(x.left);
			lrn(x.right);
			System.out.println(x.toString());
		}
	}

	public void lrn() {
		lrn(parent);
	}

	// NODE - LEFT - RIGHT 
	private void nlr(Node x) {
		if(x != null) {
			System.out.println(x.toString());
			nlr(x.left);
			nlr(x.right);
		}
	}

	public void nlr() {
		nlr(parent);
	}

	// RIGHT - NODE - LEFT
	private void rnl(Node x) {
		if(x != null) {
			rnl(x.right);
			System.out.println(x.toString());
			rnl(x.left);
		}
	}

	public void rnl() {
		rnl(parent);
	}

	// NODE - RIGHT - LEFT
	private void nrl(Node x) {
		if(x != null) {
			System.out.println(x.toString());
			nrl(x.right);
			nrl(x.left);
		}
	}

	public void nrl() {
		nrl(parent);
	}

	// RIGHT - LEFT - NODE
	private void rln(Node x) {
		if(x != null) {
			rln(x.right);
			rln(x.left);
			System.out.println(x.toString());
		}
	}

	public void rln() {
		rln(parent);
	}


	// GIAI THUAT TIM KIEM
	// .. THEO MA SO SINH VIEN
	private Node get(Node x, Integer studentId) {
		if(x == null) {
			System.out.println("Sinh Viên không tồn tại");
			return null;
		} 

		int cmp = studentId.compareTo(x.studentId);

		if(cmp < 0) 
			return get(x.left, studentId);
		else if(cmp > 0) 
			return get(x.right, studentId);
		else  
			return x;
	}

	public void get(Integer studentId) {

		Node x = get(parent, studentId);
		if(x != null) {
			System.out.println(x.toString());
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}

	// Tim sinh vien theo ten: 
	public void getSvByName(Node x, String name) {
		if(x != null) {
			if(name.equals(x.name)) {
				System.out.println(x);
			}
			getSvByName(x.left, name);
			getSvByName(x.right, name);
		}
	}

	
	public void getSvByName(String name) {
		getSvByName(parent, name);
	}
	
	// Tim sinh vien theo ngay sinh
	private void getSvByDate(Node x, String dateOfBirth) {
		if(x != null) {
			if(dateOfBirth.equals(x.dateOfBirth)) {
				System.out.println(x);
			}
			getSvByDate(x.left, dateOfBirth);
			getSvByDate(x.right, dateOfBirth);
		}
	}

	public void getSvByDate(String dateOfBirth) {
		getSvByDate(parent, dateOfBirth);
	}

	// Tim SinhVien theo diem trung binh
	private void getSvByAverage(Node x, Double avgGrade) {
		if(x != null) {
			if(Double.compare(avgGrade, x.avgGrade) == 0) {
				System.out.println(x);
			}
			getSvByAverage(x.left, avgGrade);
			getSvByAverage(x.right, avgGrade);
		}
	}

	public void getSvByAverage(Double avgGrade) {
		getSvByAverage(parent, avgGrade);
	}

	// Tim SinhVien theo tin chi
	private void getSvByTinChi(Node x, int tc) {
		if(x != null) {
			if(tc == x.tc) {
				System.out.println(x);
			}
			getSvByTinChi(x.left, tc);
			getSvByTinChi(x.right, tc);
		}
	}

	public void getSvByTinChi(int tc) {
		getSvByTinChi(parent, tc);
	}

	// XOA PHAN TU NHO NHAT TRONG CAY BAT DAU TU NODE X
	public void deleteMin() {
		parent = deleteMin(parent);
	}

	private Node deleteMin(Node x) {

		if(x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	// XOA PHAN TU TRONG CAY
	public void delete(Integer studentId) {
		parent = delete(parent, studentId);
	}

	private Node delete(Node x, Integer studentId) {
		if(x == null) return null;

		int cmp = studentId.compareTo(x.studentId);
		if(cmp < 0) {
			x.left = delete(x.left, studentId);
		} else if(cmp > 0) {
			x.right = delete(x.right, studentId);
		} else {
			if(x.right == null) 
				return x.left;
			if(x.left == null)
				return x.right;

			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	// XOA PHAN TU LON NHAT TRONG CAY TAI NODE X
	public void deleteMax() {
		parent = deleteMax(parent);
	}

	private Node deleteMax(Node x) {
		if(x.right == null) 
			return x.left;
		
		x.right = deleteMax(x.right);
		x.size = size(x.left) + size(x.right) + 1;

		return x;
	}
	
	public void deleteList(ArrayList<Integer> studentId) {
		for(Integer id: studentId) {
			parent = delete(parent, id);
		}
	}

	public boolean contains(Integer studentId) {
		return contains(parent, studentId) != null;
	}

	private Node contains(Node x, Integer studentId) {
		return get(x, studentId);
	}

	// Predecessor:
	public void predecessor(Integer studentId) {
		Node x = get(parent, studentId);
		if(x != null) {
			System.out.println(predecessor(x));
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}

	private Node predecessor(Node node) {
		return predecessor(parent, node);
	}

	private Node predecessor(Node x, Node node) {

		if(node.left != null) 
			return max(node.left);
		
		Node pre = null;

		while(x != null) {

			if(node.studentId == x.studentId) {
				break;
			} else if(node.studentId < x.studentId) {
				x = x.left;
			} else if(node.studentId > x.studentId) {
				pre = x;
			}
		}
		return pre;
	}


	// Successor
	public void successor(Integer studentId) {
		Node x = get(parent, studentId);
		if(x != null) {
			System.out.println(successor(x));
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}

	private Node successor(Node node) {
		return successor(parent, node);
	}

	private Node successor(Node x, Node node) {
		
		if(node.right != null) 
			return min(node.right);
		
		Node pre = null;

		while(x != null) {

			if(node.studentId == x.studentId) {
				break;
			} else if(node.studentId > x.studentId) {
				x = x.right;
			} else if(node.studentId < x.studentId) {
				pre = x;
			}
		}

		return pre;
	}


	// CAP NHAT THONG TIN SINH VIEN
	public void updateName(Integer studentId, String name) {

		Node x = get(parent, studentId);

		if(x != null) {
			x.name = name;
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}

	public void updateDate(Integer studentId, String dateOfBirth) {

		Node x = get(parent, studentId);
		if(x != null) {
			x.dateOfBirth = dateOfBirth;
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}

	public void updateDTB(Integer studentId, Double avgGrade) {

		Node x = get(parent, studentId);
		if(x != null) {
			x.avgGrade = avgGrade;
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}

	public void updateTC(Integer studentId, int tc) {

		Node x = get(parent, studentId);

		if(x != null) {
			x.tc = tc;
		} else {
			System.out.println("Sinh viên không tồn tại");
		}
	}
}