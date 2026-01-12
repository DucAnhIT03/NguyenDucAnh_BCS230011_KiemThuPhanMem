# Bài tập thực hành kiểm thử với JUnit

## 1. Giới thiệu
Bài tập: Phân tích dữ liệu điểm số học sinh bằng Java, viết kiểm thử tự động với JUnit 5.
Hai chức năng chính trong lớp `StudentAnalyzer`:
- `countExcellentStudents(List<Double> scores)`: đếm số học sinh đạt loại Giỏi (>= 8.0); bỏ qua dữ liệu không hợp lệ (<0 hoặc >10); danh sách rỗng trả về 0.
- `calculateValidAverage(List<Double> scores)`: tính điểm trung bình của các điểm hợp lệ (0..10); bỏ qua dữ liệu sai; danh sách rỗng hoặc không có điểm hợp lệ trả về 0.0.

## 1.1. Yêu cầu và ràng buộc chi tiết
- Input: danh sách điểm `Double` có thể chứa null, giá trị âm hoặc >10 (coi là dữ liệu sai cần bỏ qua).
- Quy tắc validate: chỉ chấp nhận điểm trong [0, 10]; giá trị null hoặc ngoài khoảng bị bỏ qua.
- Giá trị trả về:
   - `countExcellentStudents`: số lượng điểm hợp lệ >= 8.0; danh sách null/rỗng trả về 0.
   - `calculateValidAverage`: trung bình cộng các điểm hợp lệ; nếu không có điểm hợp lệ trả về 0.0 (tránh chia cho 0).
- Yêu cầu về vòng lặp: dùng 2 lần duyệt độc lập để tách biệt logic đếm và tính trung bình.

## 1.2. Thuật toán tóm tắt
- Bước chung: kiểm tra null/rỗng và trả về giá trị mặc định.
- Đếm học sinh Giỏi: duyệt từng phần tử, bỏ qua null/ngoài [0,10], tăng đếm khi >= 8.0.
- Tính trung bình hợp lệ: duyệt lần hai, cộng dồn các giá trị hợp lệ và đếm; nếu `validCount == 0` thì trả về 0.0, ngược lại `sum / validCount`.

## 1.3. Lý do chọn xử lý này
- Tách hai vòng lặp giúp mã rõ ràng theo yêu cầu bài; dễ mở rộng (ví dụ thêm thống kê khác) mà không làm rối logic.
- Trả về 0/0.0 khi không có dữ liệu hợp lệ giúp tránh `ArithmeticException` và phản ánh “không có kết quả”.

## 2. Mục tiêu học tập
- Biết viết kiểm thử tự động bằng JUnit 5.
- Hiểu validate dữ liệu và xử lý biên.
- Thực hành khai thác AI tạo sinh hỗ trợ lập trình (gợi ý test, rà soát logic).

## 3. Cấu trúc thư mục
```
unit-test/
   src/
      StudentAnalyzer.java
   test/
      StudentAnalyzerTest.java
   README.md (tài liệu này)
```

## 4. Mô tả chức năng chi tiết
- Điều kiện chung: mọi giá trị ngoài [0, 10] hoặc null đều bị bỏ qua.
- Nếu danh sách rỗng hoặc null: trả về 0 (đếm) hoặc 0.0 (trung bình).
- Vòng lặp 1: duyệt danh sách để đếm số điểm >= 8.0 (điểm Giỏi) sau khi validate.
- Vòng lặp 2: duyệt danh sách để cộng dồn và đếm điểm hợp lệ, sau đó tính trung bình hợp lệ.

## 5. Kiểm thử đơn vị (JUnit 5)
Các nhóm tình huống đã kiểm thử trong `StudentAnalyzerTest`:
- Trường hợp bình thường: danh sách có cả hợp lệ và không hợp lệ.
- Trường hợp biên: danh sách trống; danh sách toàn 0; danh sách toàn 10.
- Trường hợp ngoại lệ dữ liệu: có điểm <0, >10, hoặc null.
- Số thực so sánh với `delta` 0.01.

### 5.1. Bảng test case chính
- `countExcellentStudents`
   - Hợp lệ + không hợp lệ: [9.0, 8.5, 7.0, 11.0, -1.0] → 2
   - Rỗng: [] → 0
   - Toàn 0: [0,0,0] → 0
   - Toàn 10: [10,10,10] → 3
   - Toàn dữ liệu sai: [-5, 11, 12.5] → 0
- `calculateValidAverage`
   - Hợp lệ + không hợp lệ: [9.0, 8.5, 7.0, 11.0, -1.0] → 8.17 (delta 0.01)
   - Rỗng: [] → 0.0
   - Toàn 0: [0,0,0] → 0.0
   - Toàn 10: [10,10,10] → 10.0
   - Toàn dữ liệu sai hoặc null: [-3.0, 15.0, null] → 0.0

## 6. Cách chạy kiểm thử
### 6.1. Chuẩn bị
- Yêu cầu: JDK 17+ (có sẵn `javac`, `java`).
- Tải JUnit Platform Console Standalone (ví dụ 1.10.2):
   https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/
- Đặt đường dẫn jar vào biến môi trường tạm `JUNIT_JAR`.

Ví dụ trên Windows (PowerShell):
```
$env:JUNIT_JAR="C:\\path\\to\\junit-platform-console-standalone-1.10.2.jar"
```
Hoặc CMD:
```
set JUNIT_JAR=C:\path\to\junit-platform-console-standalone-1.10.2.jar
```

### 6.2. Biên dịch
Chạy trong thư mục gốc repo (có thư mục `unit-test/`):
```
javac -cp "%JUNIT_JAR%" -d unit-test/out unit-test/src/StudentAnalyzer.java unit-test/test/StudentAnalyzerTest.java
```
- Thư mục `unit-test/out/` sẽ chứa file `.class` sau biên dịch.

Nếu chưa có thư mục `out`, tạo trước:
```
mkdir unit-test/out
```

### 6.3. Chạy test
```
java -jar "%JUNIT_JAR%" -cp unit-test/out --scan-class-path
```
- JUnit sẽ tự quét `unit-test/out/` và thực thi `StudentAnalyzerTest`.

### 6.4. Tuỳ chọn: chạy từ thư mục unit-test
Bạn có thể `cd unit-test` rồi:
```
javac -cp "%JUNIT_JAR%" -d out src/StudentAnalyzer.java test/StudentAnalyzerTest.java
java -jar "%JUNIT_JAR%" -cp out --scan-class-path
```

### 6.5. Kiểm thử thủ công nhanh
Bạn cũng có thể viết một `main` ngắn (không bắt buộc) để in ra kết quả mẫu, nhưng ưu tiên dùng JUnit để tự động hóa.

## 7. Kết quả mong đợi
- Tất cả test pass.
- Giá trị ngoài [0,10] hoặc null không ảnh hưởng kết quả.
- Danh sách rỗng hoặc không có điểm hợp lệ trả về 0 (đếm) và 0.0 (trung bình).

## 8. Ghi chú issue và commit (theo yêu cầu bài)
- Tạo các issue: (1) countExcellentStudents; (2) calculateValidAverage; (3) viết test; (4) viết README.
- Gợi ý commit: `feat: implement countExcellentStudents() #1`, `feat: implement calculateValidAverage() #2`, `test: add unit tests for both methods #3`, `docs: update README #4`.

## 9. Khai thác AI tạo sinh (gợi ý)
- Hỏi AI đề xuất test biên: null, âm, >10, toàn 0, toàn 10.
- Nhờ AI rà soát logic: bỏ qua null, tránh chia cho 0 khi không có điểm hợp lệ.
- Hỏi AI hướng dẫn chạy JUnit console hoặc thiết lập Maven/Gradle nếu muốn tự động hóa.
