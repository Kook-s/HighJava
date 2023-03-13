package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 *  문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
 *        Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 *        - Map의 구조 : key값은 입력한 '이름'으로 사용하고 
 *                       value값은 Phone클래스의 인스턴스로 한다.
 *        예) HashMap<String,Phone> 변수명;
 *        - 아래의 메뉴를 구현한다.
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        
 *        - 삭제, 검색 기능은 '이름'을 입력 받아 처리한다.
 *        
 *        실행예시)
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 1
 *        
 *        새롭게 등록할 전화번호 정보를 입력하세요.
 *        이 름 >> 홍길동
 *        전화번호 >> 010-1111-1111
 *        주소 >> 대전시 중구 오류동
 *        
 *        '홍길동'씨의 전화번호 정보가 등록되었습니다.
 *        
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 1
 *        
 *        새롭게 등록할 전화번호 정보를 입력하세요.
 *        이 름 >> 홍길동
 *        
 *        
 *        '홍길동'씨의 이미 등록되었습니다.
 *        
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 5
 *        
 *        -----------------------------------------------------
 *        번호       이름         전화번호      주소
 *         1         홍길동     010-1111-1111  대전 중구 오류동
 *        -----------------------------------------------------  
 *        출력 완료...
 *        
 *        ------------------------------
 *        1. 전화번호 등록
 *        2. 전화번호 수정
 *        3. 전화번호 삭제
 *        4. 전화번호 검색
 *        5. 전화번호 전체 출력
 *        0. 프로그램 종료
 *        ------------------------------
 *        번호입력 >> 0
 *        
 *        프로그램을 종료합니다...
 */
public class PhoneBookTest {
   Scanner scanner = new Scanner(System.in);
   HashMap<String, Phone> member = new HashMap<>();
   Phone phone = new Phone(null, null, null);
   private String fileName = "d:/d_other/phoneData.bin"; // 저장 파일명
   
   // 데이터의 변화가 있었는지 여부를 저장하는 변수
   // 데이터의 변화가 있으면 이 변수값이 true가 된다.
   private boolean isDataChange = false;
   
   //생성자
   public PhoneBookTest() {
      member = load(); // 파일 내용을 읽어와Map에 저장하기
      if(member == null) { // 파일이 없을 때...
         member = new HashMap<>();
      }
   }
   public static void main(String[] args) {
      PhoneBookTest pb = new PhoneBookTest();
      pb.start();

   }

   private void start() {
      while (true) {
         int choice = menu();
         switch (choice) {
         case 1:
            regist();
            break;
         case 2:
            correction();
            break;
         case 3:
            delete();
            break;
         case 4:
            search();
            break;
         case 5:
            allSearch();
            break;
         case 6:
            save();
            break;
         case 0:
            if(isDataChange==true) {
               save();
               System.out.println("프로그램을 종료합니다.");
            }else {
               
               System.out.println("프로그램을 종료합니다.");
            }
            return;
         default:
            break;
         }
      }

   }

   private int menu() {

      System.out.println("———————————————");
      System.out.println(" 1. 전화번호 등록");
      System.out.println(" 2. 전화번호 수정");
      System.out.println(" 3. 전화번호 삭제");
      System.out.println(" 4. 전화번호 검색");
      System.out.println(" 5. 전화번호 전체 출력");
      System.out.println(" 6. 전화번호 저장");
      System.out.println(" 0. 프로그램 종료");
      System.out.println(" ———————————————");
      System.out.println("번호입력 >> ");
      return scanner.nextInt();
   }

   private void regist() {

      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
      System.out.println("이 름 >> ");
      String name = scanner.next();
      phone.setName(name);

      if (member.containsKey(name)) {
         System.out.println(name + "씨는 이미 등록되었습니다.");
      } else {

         System.out.println("전화번호 >> ");
         String tel = scanner.next();
         scanner.nextLine();
         System.out.println("주소 >> ");
         String addr = scanner.nextLine();
         member.put(name, new Phone(name, addr, tel));
         System.out.println();
         System.out.println(name + "씨의 전화번호 정보가 등록되었습니다.");
         isDataChange = true;
      }

   }

   private void correction() {
      System.out.println();
      scanner.nextLine();
      System.out.println("수정할 전화번호 고객을 입력하시오 >>");
      String name = scanner.nextLine();
      if (member.containsKey(name) == false) {
         System.out.println("존재하지 않는 고객입니다.");
      } else {
         System.out.println("수정할 전화번호를 입력하시오 >>");
         String tell = scanner.nextLine();
         member.get(name).setTel(tell);
         System.out.println("수정되었습니다.");
         isDataChange = true;
      }

   }

   private void delete() {
      System.out.println("삭제할 이름을 입력하시오.");
      String name = scanner.next();
      if (member.containsKey(name) == true) {
         member.remove(name);
         System.out.println(name + "씨가 삭제되었습니다.");
         isDataChange=true;
      } else {
         System.out.println("존재하지 않는 이름입니다.");
      }

   }

   private void search() {
      System.out.println("검색할 이름을 입력하시오.");
      String name = scanner.next();
      if (member.containsKey(name) == true) {
         System.out.println(name + "씨의 전화번호는 ==> " + member.get(name).getTel());
      } else {
         System.out.println("존재하지 않는 이름입니다.");
      }

   }

   private void allSearch() {
      Set<String> keySet = member.keySet();
      int cnt = 0;
      System.out.println("번호           이름         전화번호          주소     ");
      for (String p : keySet) {
         cnt++;
         System.out.println(cnt + "             " + member.get(p).getName() + "           " + member.get(p).getTel()
               + "      " + member.get(p).getAddr());
      }

   }

   // 전화번호 정보를 파일로 저장하는 메서드
   private void save() {
      ObjectOutputStream oout = null;
      try {
         // 객체 출력용 스트림 객체 생성
         oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
         // map에 저장된 전화번호 정보를 파일로 출력한다.
         // oout.writeObject(member); // Map객체 자체 저장하기 (방법1)

         // Map에 저장된 Phone객체를 하나씩 꺼내서 저장하기 (방법2)
         for (String name : member.keySet()) {
            Phone p = member.get(name);
            oout.writeObject(p);
         }
         oout.writeObject(null);
         System.out.println("저장이 완료되었습니다...");
         isDataChange = false;
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         // 스트림 닫기
         if (oout != null) {
            try {
               oout.close();
            } catch (IOException e2) {
            }
         }
      }

   }

   // 파일에 저장된 전화번호 정보를 읽어와서 map에 추가한 후 반환하는 메서드
   private HashMap<String, Phone> load() {
      HashMap<String, Phone> pMap = null; // 반환값이 저장될 변수 선언
      File file = new File(fileName);
      if (!file.exists()) { // 저장된 파일이 없으면
         return null;
      }
      // 저장된 파일 있을 때 처리되는 영역...
      ObjectInputStream oin = null;
      try {
         // 입력용 스트림 객체 생성
         oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
         
         // 파일에 저장된 데이터를 읽어와 Map 객체에 저장하기
         
         // 방법1로 저장했을 때(Map 자체를 저장했을 때...)
         // pMap = (HashMap<String, Phone>)oin.readObject();

         // 방법2로 저장했을때
         Object obj = null; // 읽어온 데이터가 저장될 변수
         pMap = new HashMap<>(); // 저장할 Map객체 생성
         while((obj=oin.readObject())!=null) {
            Phone p = (Phone) obj;
            pMap.put(p.getName(), p);
         }

      } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
      }finally {
         if(oin!=null) {
            try {
               oin.close();
            } catch (IOException e) {
               // TODO: handle exception
            }
         }
      }
      return pMap;
   }
}

class Phone implements Serializable {
   private String name;
   private String addr;
   private String tel;

   public Phone(String name, String addr, String tel) {
      super();
      this.name = name;
      this.addr = addr;
      this.tel = tel;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

}