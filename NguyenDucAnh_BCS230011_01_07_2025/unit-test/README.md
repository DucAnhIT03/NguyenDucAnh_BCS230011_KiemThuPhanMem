# Bai tap thuc hanh kiem thu voi JUnit

## Cau truc thu muc
- unit-test/src/StudentAnalyzer.java: Lop xu ly diem.
- unit-test/test/StudentAnalyzerTest.java: Bo test JUnit 5.

## Huong dan chay thu cong bang JUnit Platform Console
1) Tai file `junit-platform-console-standalone-1.10.2.jar` tu Maven Central va dat vao thu muc `unit-test/lib/`.
2) Bien dich:
   ```bash
   mkdir -p out
   javac -cp "unit-test/lib/junit-platform-console-standalone-1.10.2.jar" -d out unit-test/src/StudentAnalyzer.java unit-test/test/StudentAnalyzerTest.java
   ```
3) Chay test:
   ```bash
   java -jar unit-test/lib/junit-platform-console-standalone-1.10.2.jar -cp "out" --scan-classpath
   ```

## Ghi chu ve issue va commit (theo yeu cau bai tap)
- Tao cac issue:
   1) Viet ham countExcellentStudents()
   2) Viet ham calculateValidAverage()
   3) Viet test cho 2 ham tren
   4) Viet tai lieu README.md
- Ten commit goi y: `feat: implement countExcellentStudents() #1`, `feat: implement calculateValidAverage() #2`, `test: add unit tests for both methods #3`, `docs: update README with instructions #4`.

## Y tuong kiem thu da bao phu
- Truong hop binh thuong: danh sach co diem hop le va khong hop le.
- Truong hop bien: danh sach rong; chi co 0 hoac 10.
- Truong hop ngoai le: co diem < 0 hoac > 10 (bi bo qua).

## Goi y su dung AI ho tro
- Yeu cau AI phan tich case test tu bang yeu cau.
- Yeu cau AI viet lai doan lap duyet/loc du lieu.
- Yeu cau AI de xuat them case phu nhat (null, du lieu bi khuyet) de bo sung do bao phu.
