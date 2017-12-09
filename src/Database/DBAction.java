/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import studentinfomationclass.AYearStudent;
import studentinfomationclass.Admin;
import studentinfomationclass.Class_;
import studentinfomationclass.CreditStudent;
import studentinfomationclass.Department;
import studentinfomationclass.SignUp;
import studentinfomationclass.Student;
import studentinfomationclass.Subject;

/**
 *
 * @author PQD
 */
public class DBAction {

    private static Connection conn;

    /*truyền vào tên cột và giá trị, trả về 1 biến department tương ứng*/
    public static Department selectDepartment(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from nganh where " + str1 + " = ?";
        DBAction.conn = db.ketNoi();
        Department dep1 = new Department();

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            rs.next();

            dep1.setIdDpm(rs.getInt("idnganh"));
            dep1.setNameDpm(rs.getString("tennganh"));

            conn.close();
            return dep1;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dep1;
    }

    /*truyền vào tên cột và giá trị, trả về 1 biến kiểu subject tương ứng, nhưng không có giá trị điểm 
    giữa kì, cuối kì, trung bình, xếp loại và lớp của môn học
     */
    public static Subject selectSubject(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from monhoc where " + str1 + " = ?";
        DBAction.conn = db.ketNoi();
        Subject subj1 = new Subject();

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            rs.next();

            subj1.setIdSbj(rs.getInt("idmonhoc"));
            subj1.setNameSbj(rs.getString("tenMH"));
            subj1.setNumOfCre(rs.getInt("sotc"));
            subj1.setSemester(rs.getInt("hocki"));
            int idnganh = rs.getInt("nganh_idnganh");
            subj1.setDpm(DBAction.selectDepartment("idnganh", Integer.toString(idnganh)));

            conn.close();
            return subj1;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subj1;
    }

    /*truyền vào tên cột và giá trị, trả về 1 biến class_ tương ứng*/
    public static Class_ selectClass(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from lop where " + str1 + " = ?";
        DBAction.conn = db.ketNoi();
        Class_ cls1 = new Class_();

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            rs.next();

            cls1.setIdClass(rs.getInt("idlop"));
            int idMonHoc = rs.getInt("monhoc_idmonhoc");
            cls1.setSbj(DBAction.selectSubject("idmonhoc", Integer.toString(idMonHoc)));
//            tim them giao vien nua.

            conn.close();
            return cls1;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cls1;
    }

    /*tìm trong database dangki để lấy điểm cho các môn học. tìm idlop trong database dangki
    để tìm lớp, tim các thuộc tính môn học của lớp đó rồi gán lại, trả về 1 biến Subject
    đầy đủ thông tin
     */
    public static ArrayList selectDangKi(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from dangki where " + str1 + " = ?";
        DBAction.conn = db.ketNoi();
        ArrayList<Subject> arraySUp = new ArrayList<>();
        Subject sub1 = new Subject();

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            while (rs.next()) {

                int idlop = rs.getInt("lop_idlop");
                Class_ clss1 = DBAction.selectClass("idlop", Integer.toString(idlop));
                Subject sub2 = clss1.getSbj();

                double a1 = rs.getDouble("DiemQT");
                double a2 = rs.getDouble("DiemCK");
                double a3 = rs.getDouble("DiemTB");
                String str = rs.getString("loai");
                int ispassed = rs.getInt("ispassed");

                sub1 = new Subject(sub2.getIdSbj(), sub2.getNameSbj(), sub2.getNumOfCre(), sub2.getSemester(), sub2.getDpm(), a1, a2, a3, str, clss1, ispassed);
                arraySUp.add(sub1);
            }

            conn.close();
            return arraySUp;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arraySUp;
    }

    /*truyen vao ten cot va gia tri, trả về 1 sinh viên tín chỉ*/
    public static CreditStudent selectCreditStudent(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from sinhvien,lop,dangki where " + str1 + " = (?) and sinhvien.mssv = dangki.sinhvien_mssv and lop.idlop = dangki.lop_idlop";
        DBAction.conn = db.ketNoi();
        CreditStudent csd1 = new CreditStudent();
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            rs.next();
            int x = rs.getInt("mssv");
            csd1.setIdStu(rs.getInt("mssv"));
            csd1.setNameStu(rs.getString("hoten"));
            csd1.setAddresStu(rs.getString("quequan"));
            csd1.setCourse(rs.getString("khoahoc"));
            csd1.setBirthday(rs.getString("ngaysinh"));
            csd1.setPassStu(rs.getString("password"));
            csd1.setTrainningSys(rs.getString("hedaotao"));
            int idnganh = rs.getInt("nganh_idnganh");
            csd1.setDpm(DBAction.selectDepartment("idnganh", Integer.toString(idnganh)));
            ArrayList<Subject> sub = new ArrayList();
            sub = DBAction.selectDangKi("sinhvien_mssv", Integer.toString(rs.getInt("mssv")));
            csd1.setSub(sub);

            conn.close();
            return csd1;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return csd1;
    }

    /*truyen vao ten cot va gia tri trả về 1 sinh viên*/
    public static Student selectStudent(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from sinhvien where " + str1 + " = ? ";
        DBAction.conn = db.ketNoi();
        Student std1 = new Student() {

            public boolean themMonHoc(Subject su) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            rs.next();

            std1.setIdStu(rs.getInt("mssv"));
            std1.setNameStu(rs.getString("hoten"));
            std1.setAddresStu(rs.getString("quequan"));
            std1.setCourse(rs.getString("khoahoc"));
            std1.setBirthday(rs.getString("ngaysinh"));
            std1.setPassStu(rs.getString("password"));
            std1.setTrainningSys(rs.getString("hedaotao"));
            int idnganh = rs.getInt("nganh_idnganh");
            std1.setDpm(DBAction.selectDepartment("idnganh", Integer.toString(idnganh)));

            conn.close();
            return std1;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return std1;
    }

    /*nhập và tên cột và giá trị,tìm kiếm trong bảng admin của database
    và trả về giá trị kiểu admin tương ứng.
     */
    public static Admin selectAdmin(String str1, String str2) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from admin where " + str1 + " = ? ";
        DBAction.conn = db.ketNoi();
        Admin adm1 = new Admin();

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str2);
            ResultSet rs;
            rs = ptmt.executeQuery();
            rs.next();

            adm1.setId(rs.getString("id"));
            adm1.setPassword(rs.getString("pass"));

            conn.close();
            return adm1;

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return adm1;
    }

    /*truyền vào lần lượt tên bảng, tên cột và giá trị cụ thể để kiểm tra giá trị
    có tồn tại trong database không
     */
    public static boolean isExist(String str1, String str2, String str3) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from " + str1 + " where " + str2 + " = ?";
        Connection conn;

        try {
            conn = db.ketNoi();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, str3);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Loi:" + ex.getMessage());
        }

        return false;
    }

    /// TODO: Execute data for DangKiHocPhan
    public static ArrayList selectInfoClass(String text) {
        Connection conn = null;
        PreparedStatement ptmt = null;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        String sql = "select * from monhoc,nganh,lop where idlop = (?) and lop.monhoc_idmonhoc = monhoc.idmonhoc and monhoc.nganh_idnganh = nganh.idnganh";
        ArrayList ar = new ArrayList();
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, text);
            ResultSet rs1 = ptmt.executeQuery();
            if (rs1.next()) {
                ar.add(rs1.getString("idlop"));
                ar.add(rs1.getString("tenmh"));
                ar.add(rs1.getString("sotc"));
                ar.add(rs1.getString("hocki"));
                ar.add(rs1.getString("tennganh"));
                ar.add(rs1.getString("idmonhoc"));
                conn.close();
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        return ar;
    }

    public static ArrayList addSubject(boolean check, int idStu, int size) {
        Connection conn = null;
        PreparedStatement ptmt = null;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        ArrayList ar = new ArrayList();
        int count_tc = 0;
        if (check == false) {
            check = true;
            String sqll = "select * from lop,giaovien,monhoc,nganh,sinhvien,dangki where lop.monhoc_idmonhoc = monhoc.idmonhoc"
                    + " and giaovien.idgiaovien = lop.giaovien_idgiaovien"
                    + " and nganh.idnganh = monhoc.nganh_idnganh"
                    + " and dangki.sinhvien_mssv = sinhvien.mssv"
                    + " and dangki.lop_idlop = lop.idlop "
                    + " and mssv = " + idStu + ";";
            try {
                ptmt = conn.prepareStatement(sqll);
                ResultSet rs = ptmt.executeQuery();
                while (rs.next()) {
                    count_tc += rs.getInt("sotc");
                    String txt0 = rs.getString("idmonhoc");
                    ar.add(txt0);
                    String txt1 = rs.getString("idlop");
                    ar.add(txt1);
                    String txt2 = rs.getString("tenmh");
                    ar.add(txt2);
                    String txt3 = rs.getString("sotc");
                    ar.add(txt3);
                    String txt4 = rs.getString("hocki");
                    ar.add(txt4);
                    String txt5 = rs.getString("tennganh");
                    ar.add(txt5);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ar.add(count_tc);
        }
        return ar;
    }

    public static ArrayList addSubject(String text, String idStudent) {
        Connection conn;
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        ResultSet rs;
        int idS = Integer.parseInt(idStudent);
        int count_tc = 0;
        ArrayList ar = new ArrayList();
        String sql = "select * from lop,giaovien,monhoc,nganh where lop.monhoc_idmonhoc = monhoc.idmonhoc"
                + " and giaovien.idgiaovien = lop.giaovien_idgiaovien"
                + " and nganh.idnganh = monhoc.nganh_idnganh"
                + " and idlop = (?)";
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, text);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                count_tc += rs.getInt("sotc");
                ar.add(rs.getString("idmonhoc"));
                ar.add(rs.getString("idlop"));
                ar.add(rs.getString("tenmh"));
                ar.add(rs.getString("sotc"));
                ar.add(rs.getString("hocki"));
                ar.add(rs.getString("tennganh"));
                ar.add(rs.getInt("sotc"));
            } else {
                return null;
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Loi: " + e);
        }
        ar.add(count_tc);
        return ar;
    }

    public static void insertDangKi(int idS, int idC) {
        Connection conn;
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        ResultSet rs;
        String sqlb = "insert into dangki(diemqt,diemck,diemtb,sinhvien_mssv,lop_idlop) values (0,0,0," + idS + "," + idC + ");";
        try {
            ptmt = conn.prepareStatement(sqlb);
            ptmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int checkMon(int mssv, int idlop) {
        Connection conn = null;
        PreparedStatement ptmt = null;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        String sql = "select * from lop,monhoc where lop.monhoc_idmonhoc = monhoc.idmonhoc  and idlop =" + idlop + "";
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            rs.next();
            int mondieukien = rs.getInt("dieukien");
            if (ispassed(mondieukien, mssv) == 1) {
                return 1; /// cho phép đăng ký
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;

    }

    public static int ispassed(int mondieukien, int mssv) {
        if (mondieukien != 0) {
            Connection conn = null;
            PreparedStatement ptmt = null;
            DBConnection db = new DBConnection();
            conn = db.ketNoi();

            String sql = "select * from dangki,lop,monhoc where dangki.lop_idlop = lop.idlop and monhoc.idmonhoc = lop.monhoc_idmonhoc and idmonhoc = " + String.valueOf(mondieukien) + " and dangki.sinhvien_mssv =" + String.valueOf(mssv) + "";
            try {
                ptmt = conn.prepareStatement(sql);
                ResultSet rs = ptmt.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("ispassed") == 1) {
                        return 1;
                    }
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        return 1;
    }

    // TODO: Execute data for AdminPoint
    public static ArrayList viewTable(String text) {
        Connection conn = null;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        PreparedStatement prst = null;
        ArrayList<CreditStudent> ar = new ArrayList();
        String sql = "select * from dangki,sinhvien,lop where lop_idlop = (?) and dangki.lop_idlop = lop.idlop and sinhvien.mssv = dangki.sinhvien_mssv ";
        try {
            prst = conn.prepareStatement(sql);
            prst.setString(1, text);
            ResultSet rs = prst.executeQuery();
            if (db.isExist(sql, text)) {
                while (rs.next()) {
                    CreditStudent std = new CreditStudent();
                    std.setIdStu(rs.getInt("mssv"));
                    Class_ cl = new Class_();
                    cl.setIdClass(rs.getInt("idlop"));
                    Subject subj = new Subject();
                    subj.setEndPoint(rs.getDouble("diemck"));
                    subj.setAverPoint(rs.getDouble("diemtb"));
                    subj.setMidPoint(rs.getDouble("diemqt"));
                    subj.setType(rs.getString("loai"));
                    subj.setIspassed(rs.getInt("ispassed"));
                    subj.setCl(cl);
                    ArrayList<Subject> arSub = new ArrayList();
                    arSub.add(subj);
                    std.setSub(arSub);
                    ar.add(std);
                }
                return ar;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Subject selectSubjectAdm(String idmonhoc, String mssv) {
        PreparedStatement ptmt;
        DBConnection db = new DBConnection();
        String sql = "select * from dangki,sinhvien,lop,monhoc where idmonhoc = (?) and mssv = (?)  and monhoc.idmonhoc = lop.monhoc_idmonhoc\n" +
" and dangki.lop_idlop = lop.idlop and sinhvien.mssv = dangki.sinhvien_mssv ";
        DBAction.conn = db.ketNoi();
        Subject subj1 = new Subject();

        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, idmonhoc);
            ptmt.setString(2, mssv);
            ResultSet rs;
            rs = ptmt.executeQuery();
            if (rs.next()) {
                Class_ cl = new Class_();
                cl.setIdClass(rs.getInt("idlop"));
                subj1.setIdSbj(rs.getInt("idmonhoc"));
                subj1.setNameSbj(rs.getString("tenMH"));
                subj1.setNumOfCre(rs.getInt("sotc"));
                subj1.setSemester(rs.getInt("hocki"));
                int idnganh = rs.getInt("nganh_idnganh");
                subj1.setDpm(DBAction.selectDepartment("idnganh", Integer.toString(idnganh)));
                subj1.setType(rs.getString("loai"));
                subj1.setIspassed(rs.getInt("ispassed"));
                subj1.setCl(cl);
                subj1.setMidPoint(rs.getDouble("diemqt"));
                subj1.setAverPoint(rs.getDouble("diemtb"));
                subj1.setEndPoint(rs.getDouble("diemck"));
                return subj1;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subj1;
    }
}
