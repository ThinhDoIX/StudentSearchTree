public class TestAVL {

    public static void main(String[] args) {

        AVL treeAVL = new AVL();

        treeAVL.createTree_Random();
        treeAVL.nlr();

        System.out.println("So luong sinh vien: " + treeAVL.size());
        treeAVL.findMinMax();

        System.out.print("Sinh vien co mssv la 122 la: ");
        treeAVL.getSvById(122);

        System.out.print("Thong tin sinh vien Do Van Thanh: ");
        treeAVL.getSvByName("Do Van Thanh");
        System.out.print("Thong tin sinh vien Do Duy Thinh: ");
        treeAVL.getSvByName("Do Duy Thinh");

        System.out.println("");
        System.out.print("Thong tin Sinh vien co ngay sinh 24/02/1998");
        treeAVL.getSvByDate("24/02/1998");

        System.out.println("");
        System.out.print("Thong tin Sinh Vien co Diem Trung binh 8.0: ");
        treeAVL.getSvByAverage(8.0);

        System.out.println("");
        System.out.print("Thong tin Sinh Vien co tin chi 70: ");
        treeAVL.getSvByTinChi(70);

        System.out.println("");
        treeAVL.getSvByName("Pham Thi Chau");
        System.out.println("Thay doi thong tin cua Pham Thi Chau co diem trung binh 7.0");
        treeAVL.updateDTB(120, 7.0);
        System.out.print("Sau khi cap nhat thong tin: ");
        treeAVL.getSvByName("Pham Thi Chau");

        System.out.println("\nThông tin của sinh viên đứng trước sinh viên nào có mssv là 123: ");
        treeAVL.predecessor(123);
        System.out.println("");

        System.out.println("\nThông tin của sinh viên đứng sau sinh viên nào có mssv là 572: ");
        treeAVL.successor(572);
        System.out.println("");

        /*
        BST treeRight = new BST();
        BST treeLeft = new BST();

        // TAO CAY LECH PHAI
        Integer[] id = new Integer[7];
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

        for(int i = 0; i < id.length; i++) {
            treeRight.putRight(id[i], name[i], dateOfBirth[i], average[i], tc[i]);
        }
        
        System.out.println("Thong tin toan bo cay ben phai: ");
        treeRight.printRight();
        System.out.println("So Luong sinh vien trong cay Lech phai: " + treeRight.size() + "\n");
        
        
         // TAO CAY LECH TRAI
         for(int i = 0; i < id.length; i++) {
            treeLeft.putLeft(id[i], name[i], dateOfBirth[i], average[i], tc[i]);
         }
         
         System.out.println("Thong tin toan bo cay ben trai: ");
         treeLeft.printLeft();
         */

    }
}