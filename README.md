# Báo cáo môn Kiểm thử phần mềm

## Thông tin sinh viên
- **Họ và tên**: Nguyễn Đức Anh  
- **Mã sinh viên**: BCS230011  
- **Lớp**: 23CS2  
- **Môn học**: Kiểm thử phần mềm  
- **Giảng viên**: Trương Anh Hoàng  

---

## Bài tập ngày 05/01/2026: Can't Unsee (tên trò chơi luyện lỗi UI/UX)

### Mô tả bài tập
**Can't Unsee** (trò chơi luyện nhận diện lỗi) là một trò chơi nhỏ giúp rèn luyện khả năng phát hiện các lỗi trong thiết kế **UI/UX (giao diện người dùng/trải nghiệm người dùng)**.  
Bài tập yêu cầu quan sát và nhận diện các vấn đề liên quan đến:
- Căn chỉnh giao diện
- Khoảng cách giữa các thành phần
- Tính nhất quán
- Khả năng đọc và trải nghiệm người dùng

🔗 Liên kết bài tập: https://cantunsee.space (trang web của trò chơi)

### Kết quả đạt được
- **Điểm số**: **7830**
- **Xếp hạng**: **Bạch Kim (2% dẫn đầu)**
- **Thời gian hoàn thành**: **00:10:11**

Kết quả cho thấy khả năng quan sát và nhận diện lỗi giao diện ở mức tốt so với đa số người tham gia.

### Minh chứng hoàn thành
Ảnh chụp màn hình kết quả sau khi hoàn thành bài tập:

![Can't Unsee Result (ảnh kết quả)](./Screenshot%202026-01-05%20143631.png)

> Minh chứng thể hiện rõ:
> - Tên bài tập: *Can't Unsee*
> - Điểm số đạt được: **7830**
> - Xếp hạng: **Bạch Kim (2% dẫn đầu)**
> - Thời gian hoàn thành bài tập

### Nhận xét và đánh giá
Thông qua bài tập này, em:
- Nâng cao khả năng phát hiện lỗi giao diện người dùng
- Hiểu rõ hơn vai trò của UI/UX trong kiểm thử phần mềm
- Rèn luyện tư duy chi tiết và khả năng đánh giá trải nghiệm người dùng

Bài tập có tính thực tiễn cao, hỗ trợ tốt cho việc học môn **Kiểm thử phần mềm**.

### Cam kết
Em xin cam kết kết quả trên là **do chính em thực hiện**, không sao chép và không sử dụng bất kỳ hình thức gian lận nào.

**Sinh viên thực hiện**  
Nguyễn Đức Anh

---

## Bài tập ngày 07/01/2026: Kiểm thử với JUnit (khung kiểm thử Java)

### 1. Giới thiệu
Bài tập: Phân tích dữ liệu điểm số học sinh bằng Java, viết kiểm thử tự động với JUnit 5 (thư viện kiểm thử cho Java).  
Hai chức năng chính trong lớp `StudentAnalyzer` (lớp phân tích điểm):
- `countExcellentStudents(List<Double> scores)` (đếm học sinh Giỏi): đếm số học sinh đạt loại Giỏi (>= 8.0); bỏ qua dữ liệu không hợp lệ (<0 hoặc >10); danh sách rỗng trả về 0.
- `calculateValidAverage(List<Double> scores)` (tính trung bình hợp lệ): tính điểm trung bình của các điểm hợp lệ (0..10); bỏ qua dữ liệu sai; danh sách rỗng hoặc không có điểm hợp lệ trả về 0.0.

### 1.1. Yêu cầu và ràng buộc chi tiết
- Đầu vào: danh sách điểm `Double` (kiểu số thực của Java) có thể chứa null, giá trị âm hoặc >10 (coi là dữ liệu sai cần bỏ qua).
- Quy tắc kiểm tra hợp lệ: chỉ chấp nhận điểm trong [0, 10]; giá trị null hoặc ngoài khoảng bị bỏ qua.
- Giá trị trả về:
   - `countExcellentStudents`: số lượng điểm hợp lệ >= 8.0; danh sách null/rỗng trả về 0.
   - `calculateValidAverage`: trung bình cộng các điểm hợp lệ; nếu không có điểm hợp lệ trả về 0.0 (tránh ngoại lệ `ArithmeticException` - lỗi chia cho 0).
- Yêu cầu về vòng lặp: dùng 2 lần duyệt độc lập để tách biệt logic đếm và tính trung bình.

### 1.2. Thuật toán tóm tắt
- Bước chung: kiểm tra null/rỗng và trả về giá trị mặc định.
- Đếm học sinh Giỏi: duyệt từng phần tử, bỏ qua null/ngoài [0,10], tăng đếm khi >= 8.0.
- Tính trung bình hợp lệ: duyệt lần hai, cộng dồn các giá trị hợp lệ và đếm; nếu `validCount == 0` thì trả về 0.0, ngược lại `sum / validCount`.

### 1.3. Lý do chọn xử lý này
- Tách hai vòng lặp giúp mã rõ ràng theo yêu cầu bài; dễ mở rộng mà không làm rối logic.
- Trả về 0/0.0 khi không có dữ liệu hợp lệ giúp tránh `ArithmeticException` (ngoại lệ khi chia cho 0) và phản ánh “không có kết quả”.

### 2. Mục tiêu học tập
- Biết viết kiểm thử tự động bằng JUnit 5 (khung kiểm thử Java).
- Hiểu kiểm tra tính hợp lệ dữ liệu và xử lý biên.
- Thực hành khai thác AI tạo sinh hỗ trợ lập trình (gợi ý test, rà soát logic).

### 3. Cấu trúc thư mục
```
unit-test/
   src/
      StudentAnalyzer.java
   test/
      StudentAnalyzerTest.java
   README.md (tài liệu này)
```

### 4. Mô tả chức năng chi tiết
- Điều kiện chung: mọi giá trị ngoài [0, 10] hoặc null đều bị bỏ qua.
- Nếu danh sách rỗng hoặc null: trả về 0 (đếm) hoặc 0.0 (trung bình).
- Vòng lặp 1: duyệt danh sách để đếm số điểm >= 8.0 (điểm Giỏi) sau khi kiểm tra hợp lệ.
- Vòng lặp 2: duyệt danh sách để cộng dồn và đếm điểm hợp lệ, sau đó tính trung bình hợp lệ.

### 5. Kiểm thử đơn vị (JUnit 5 - khung kiểm thử Java)
Các nhóm tình huống đã kiểm thử trong `StudentAnalyzerTest`:
- Trường hợp bình thường: danh sách có cả hợp lệ và không hợp lệ.
- Trường hợp biên: danh sách trống; danh sách toàn 0; danh sách toàn 10.
- Trường hợp ngoại lệ dữ liệu: có điểm <0, >10, hoặc null.
- Số thực so sánh với sai số ±0.01.

#### 5.1. Bảng ca kiểm thử chính
- `countExcellentStudents`
   - Trộn điểm hợp lệ và không hợp lệ: [9.0, 8.5, 7.0, 11.0, -1.0] → 2
   - Rỗng: [] → 0
   - Toàn 0: [0,0,0] → 0
   - Toàn 10: [10,10,10] → 3
   - Toàn dữ liệu sai: [-5, 11, 12.5] → 0
- `calculateValidAverage`
   - Trộn điểm hợp lệ và không hợp lệ: [9.0, 8.5, 7.0, 11.0, -1.0] → 8.17 (sai số cho phép 0.01)
   - Rỗng: [] → 0.0
   - Toàn 0: [0,0,0] → 0.0
   - Toàn 10: [10,10,10] → 10.0
   - Toàn dữ liệu sai hoặc null: [-3.0, 15.0, null] → 0.0

### 6. Cách chạy kiểm thử
- Yêu cầu: JDK 17+ (bộ phát triển Java, có sẵn `javac`, `java`).
- Tải JUnit Platform Console Standalone (gói chạy JUnit độc lập, ví dụ 1.10.2):
   https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/
- Đặt đường dẫn jar vào biến môi trường tạm `JUNIT_JAR`.

Ví dụ trên Windows (PowerShell - terminal của Windows):
```
$env:JUNIT_JAR="C:\\path\\to\\junit-platform-console-standalone-1.10.2.jar"
```
Ví dụ trên CMD (Command Prompt):
```
set JUNIT_JAR=C:\path\to\junit-platform-console-standalone-1.10.2.jar
```

#### 6.2. Biên dịch
Tại thư mục gốc của kho mã nguồn (chứa thư mục `unit-test/`), tạo thư mục đầu ra nếu chưa có:
```
mkdir unit-test/out
```
Biên dịch mã nguồn và tệp kiểm thử:
```
javac -cp "%JUNIT_JAR%" -d unit-test/out unit-test/src/StudentAnalyzer.java unit-test/test/StudentAnalyzerTest.java
```

#### 6.3. Chạy kiểm thử
Chạy bảng điều khiển JUnit để quét classpath (đường dẫn chứa class) và thực thi kiểm thử:
```
java -jar "%JUNIT_JAR%" -cp unit-test/out --scan-class-path
```

#### 6.4. Tuỳ chọn: chạy khi đang ở thư mục unit-test
Nếu bạn `cd unit-test` trước, có thể dùng lệnh ngắn gọn:
```
javac -cp "%JUNIT_JAR%" -d out src/StudentAnalyzer.java test/StudentAnalyzerTest.java
java -jar "%JUNIT_JAR%" -cp out --scan-class-path
```

#### 6.5. Kỳ vọng khi chạy
- Toàn bộ kiểm thử trong `StudentAnalyzerTest` hiển thị trạng thái PASSED (thành công theo thông báo của JUnit).
- Không có lỗi ClassNotFound (không tìm thấy lớp); nếu có, kiểm tra biến `JUNIT_JAR` và đường dẫn `out`.


