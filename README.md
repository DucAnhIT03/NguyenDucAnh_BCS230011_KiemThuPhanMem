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

![Can't Unsee Result (ảnh kết quả - Can't Unsee Result)](./cantunsee.png)

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

## Bài tập ngày 07/01/2026: Kiểm thử với JUnit (khung kiểm thử Java - Java Testing Framework)

### 1. Giới thiệu
Bài tập: Phân tích dữ liệu điểm số học sinh bằng Java (ngôn ngữ lập trình Java), viết kiểm thử tự động với JUnit 5 (thư viện kiểm thử cho Java - Java Testing Framework).  
Hai chức năng chính trong lớp `StudentAnalyzer` (lớp phân tích điểm - Student Analyzer class):
- `countExcellentStudents(List<Double> scores)` (đếm học sinh Giỏi - count excellent students): đếm số học sinh đạt loại Giỏi (>= 8.0); bỏ qua dữ liệu không hợp lệ (<0 hoặc >10); danh sách rỗng trả về 0. (`List<Double>` là danh sách kiểu số thực - list of double precision floating point numbers)
- `calculateValidAverage(List<Double> scores)` (tính trung bình hợp lệ - calculate valid average): tính điểm trung bình của các điểm hợp lệ (0..10); bỏ qua dữ liệu sai; danh sách rỗng hoặc không có điểm hợp lệ trả về 0.0.

### 1.1. Yêu cầu và ràng buộc chi tiết
- Đầu vào: danh sách điểm `Double` (kiểu số thực của Java - double precision floating point number) có thể chứa null (giá trị rỗng - empty value), giá trị âm hoặc >10 (coi là dữ liệu sai cần bỏ qua).
- Quy tắc kiểm tra hợp lệ: chỉ chấp nhận điểm trong [0, 10]; giá trị null hoặc ngoài khoảng bị bỏ qua.
- Giá trị trả về:
   - `countExcellentStudents`: số lượng điểm hợp lệ >= 8.0; danh sách null/rỗng trả về 0.
   - `calculateValidAverage`: trung bình cộng các điểm hợp lệ; nếu không có điểm hợp lệ trả về 0.0 (tránh ngoại lệ `ArithmeticException` - lỗi chia cho 0 - arithmetic exception: division by zero error).
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
- Yêu cầu: JDK 17+ (bộ phát triển Java - Java Development Kit, có sẵn `javac` - trình biên dịch Java, `java` - trình chạy Java).
- Tải JUnit Platform Console Standalone (gói chạy JUnit độc lập - standalone JUnit runner package, ví dụ 1.10.2):
   https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/
- Đặt đường dẫn jar (file Java Archive - định dạng file nén chứa các file Java) vào biến môi trường tạm `JUNIT_JAR`.

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
Chạy bảng điều khiển JUnit để quét classpath (đường dẫn chứa class - class path: directory containing compiled Java classes) và thực thi kiểm thử:
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
- Toàn bộ kiểm thử trong `StudentAnalyzerTest` hiển thị trạng thái PASSED (thành công - passed: test succeeded theo thông báo của JUnit).
- Không có lỗi ClassNotFound (không tìm thấy lớp - class not found error); nếu có, kiểm tra biến `JUNIT_JAR` và đường dẫn `out`.


## Bài tập ngày 14/01/2026: Kiểm thử hiệu năng với JMeter

### 1. Giới thiệu
Bài tập: Sử dụng **Apache JMeter** (công cụ kiểm thử hiệu năng mã nguồn mở - open source performance testing tool) để thực hiện kiểm thử hiệu năng trên một trang web.  
Mục tiêu của bài tập:
- Hiểu cách sử dụng JMeter để thực hiện kiểm thử hiệu năng
- Thiết kế kịch bản kiểm thử với các tham số khác nhau (có tính cá nhân hoá)
- Phân tích kết quả kiểm thử và viết báo cáo

### 1.1. Website được kiểm thử
- **URL**: https://vnexpress.net
- **Mô tả**: Trang tin tức điện tử hàng đầu Việt Nam
- **Lý do chọn**: Website có lượng truy cập lớn, phù hợp để kiểm thử hiệu năng và đánh giá khả năng xử lý tải của hệ thống

### 2. Mục tiêu học tập
- Biết cách cài đặt và sử dụng JMeter để kiểm thử hiệu năng
- Hiểu các khái niệm về Thread Group (nhóm luồng - group of threads/users), HTTP Request (yêu cầu HTTP - HTTP request), Listeners (bộ lắng nghe - components that collect and display test results)
- Biết cách thiết kế kịch bản kiểm thử với các tham số khác nhau (số lượng người dùng, thời gian chạy, hành vi người dùng)
- Hiểu cách phân tích các chỉ số quan trọng: Response Time (thời gian phản hồi - response time), Throughput (thông lượng - throughput: requests per second), Error Rate (tỷ lệ lỗi - error rate: percentage of failed requests)
- Thực hành viết báo cáo kiểm thử hiệu năng

### 3. Cấu trúc thư mục
```
jmeter/
├── performance-test-plan.jmx    # File test plan JMeter (kế hoạch kiểm thử - test plan file)
├── README.md                    # Hướng dẫn chi tiết sử dụng JMeter
├── REPORT.md                    # Template báo cáo kết quả kiểm thử (mẫu báo cáo - report template)
├── QUICK_START.md              # Hướng dẫn nhanh (hướng dẫn nhanh - quick start guide)
├── .gitignore                   # Git ignore file (file bỏ qua của Git - Git ignore configuration)
└── results/                     # Thư mục lưu kết quả test (kết quả - results directory)
    ├── results.jtl              # File kết quả JMeter (file kết quả - JMeter results file)
    └── report/                  # HTML report (báo cáo HTML - HTML report directory)
```

### 4. Cấu hình Test Plan

File `performance-test-plan.jmx` chứa **3 kịch bản kiểm thử** (Thread Groups - nhóm luồng: group of threads/users) với các tham số khác nhau:

#### 4.1. Thread Group 1: Kịch bản cơ bản
- **Số lượng người dùng (Threads - luồng)**: 10
- **Số lần lặp (Loop Count - số vòng lặp)**: 5
- **Ramp-up Period (thời gian tăng dần)**: 1 giây
- **Tổng số request (yêu cầu)**: 10 × 5 = 50 requests
- **Endpoint được test (điểm cuối được kiểm thử)**: 
  - GET `/` (Trang chủ)
- **Mục đích**: Kiểm tra hiệu năng cơ bản của website với lượng truy cập nhỏ

#### 4.2. Thread Group 2: Kịch bản tải nặng
- **Số lượng người dùng (Threads - luồng)**: 50
- **Ramp-up Period (thời gian tăng dần)**: 30 giây (tăng dần từ 0 đến 50 users trong 30 giây)
- **Tổng số request (yêu cầu)**: ~100 requests (50 users × 2 endpoints)
- **Endpoints được test (điểm cuối được kiểm thử)**: 
  - GET `/` (Trang chủ)
  - GET `/tim-kiem?q=tin tức` (Trang tìm kiếm)
- **Mục đích**: Kiểm tra khả năng xử lý tải cao của hệ thống khi có nhiều người dùng đồng thời

#### 4.3. Thread Group 3: Kịch bản tùy chỉnh
- **Số lượng người dùng (Threads - luồng)**: 20
- **Thời gian chạy (Duration - thời lượng)**: 60 giây
- **Ramp-up Period (thời gian tăng dần)**: 10 giây
- **Endpoints được test (điểm cuối được kiểm thử)**: 
  - GET `/the-thao` (Trang thể thao)
  - GET `/so-hoa` (Trang công nghệ)
- **Mục đích**: Mô phỏng người dùng duyệt nhiều trang khác nhau trong một phiên làm việc

### 5. Các thành phần trong Test Plan

#### 5.1. HTTP Request Defaults (Mặc định yêu cầu HTTP)
- Cấu hình URL cơ sở: `${BASE_URL}` (mặc định: `https://vnexpress.net`)
- Cho phép dễ dàng thay đổi website cần test bằng cách sửa biến `BASE_URL`

#### 5.2. Listeners (Bộ lắng nghe)
- **Summary Report (Báo cáo tóm tắt)**: Hiển thị tổng quan về kết quả test (Response Time - thời gian phản hồi, Throughput - thông lượng, Error Rate - tỷ lệ lỗi)
- **View Results Tree (Xem cây kết quả)**: Hiển thị chi tiết từng request (Request/Response headers - tiêu đề yêu cầu/phản hồi, body - nội dung, status code - mã trạng thái)

### 6. Cách chạy kiểm thử

#### 6.1. Yêu cầu hệ thống
- **Java**: JDK 8+ (Java Development Kit - bộ phát triển Java) hoặc JRE 8+ (Java Runtime Environment - môi trường chạy Java) (JMeter yêu cầu Java để chạy)
- **JMeter**: Tải từ https://jmeter.apache.org/download_jmeter.cgi
- Kiểm tra Java đã cài đặt:
  ```bash
  java -version
  ```

#### 6.2. Chạy Test Plan (GUI Mode - Chế độ giao diện đồ họa)
1. Mở JMeter: Chạy file `bin/jmeter.bat` (Windows) hoặc `bin/jmeter.sh` (Linux/Mac)
2. Mở Test Plan (Kế hoạch kiểm thử): **File** → **Open** → Chọn `jmeter/performance-test-plan.jmx`
3. Tùy chỉnh URL (nếu cần): Mở **User Defined Variables (Biến do người dùng định nghĩa)** → Sửa `BASE_URL`
4. Chạy từng Thread Group:
   - **Vô hiệu hóa** các Thread Group không cần: Click phải → **Disable (Tắt)**
   - **Kích hoạt** Thread Group cần chạy: Click phải → **Enable (Bật)**
   - Click nút **Start (Bắt đầu)** (▶)
5. Xem kết quả trong **Summary Report (Báo cáo tóm tắt)** và **View Results Tree (Xem cây kết quả)**
6. Lưu kết quả:
   - Summary Report: Click phải → **Save Table Data (Lưu dữ liệu bảng)** → Lưu CSV (Comma Separated Values - giá trị phân tách bằng dấu phẩy)
   - View Results Tree: Chụp màn hình hoặc Save Table Data

#### 6.3. Chạy Test Plan (Command Line - Dòng lệnh - Khuyến nghị cho test lớn)
Chạy ở chế độ non-GUI (không giao diện đồ họa - non-GUI mode: faster and uses less resources than GUI mode):

```bash
# Di chuyển đến thư mục jmeter
cd jmeter

# Chạy test và tạo HTML report
jmeter -n -t performance-test-plan.jmx -l results/results.jtl -e -o results/report/

# Xem HTML report
# Mở file: results/report/index.html trong trình duyệt
```

Giải thích các tham số:
- `-n`: Chạy ở chế độ non-GUI (không giao diện đồ họa - non-GUI mode)
- `-t`: Đường dẫn đến file test plan (kế hoạch kiểm thử - test plan file) (.jmx)
- `-l`: Đường dẫn file kết quả (results file) (.jtl - JMeter Test Log)
- `-e`: Tạo HTML report (báo cáo HTML - HTML report) sau khi test xong
- `-o`: Thư mục chứa HTML report (báo cáo HTML - HTML report directory)

### 7. Các chỉ số quan trọng cần phân tích

#### 7.1. Response Time (Thời gian phản hồi)
- **Average (Trung bình)**: Thời gian phản hồi trung bình (ms - milliseconds: mili giây)
- **Median (Trung vị)**: Thời gian phản hồi ở giữa (50th percentile - phân vị thứ 50)
- **Min/Max (Tối thiểu/Tối đa)**: Thời gian phản hồi nhỏ nhất/lớn nhất (ms)
- **90th/95th/99th Percentile (Phân vị 90/95/99)**: Thời gian phản hồi của 90%/95%/99% request (yêu cầu)
- **Đánh giá**: Response time càng thấp càng tốt, thường < 2000ms được coi là tốt

#### 7.2. Throughput (Thông lượng)
- Số lượng request (yêu cầu) được xử lý mỗi giây (requests/second - yêu cầu/giây)
- **Đánh giá**: Throughput càng cao càng tốt, thể hiện khả năng xử lý của server (máy chủ)

#### 7.3. Error Rate (Tỷ lệ lỗi)
- Tỷ lệ request (yêu cầu) bị lỗi (%)
- **Đánh giá**: Nên < 1% trong điều kiện bình thường, = 0% là lý tưởng

#### 7.4. Concurrent Users (Người dùng đồng thời)
- Số lượng người dùng cùng lúc
- **Ảnh hưởng**: Ảnh hưởng trực tiếp đến Response Time (thời gian phản hồi) và Throughput (thông lượng)

### 8. Kết quả kiểm thử


#### 8.1. Thread Group 1: Kịch bản cơ bản
- **Samples (Mẫu)**: 50
- **Average Response Time (Thời gian phản hồi trung bình)**: 420 ms
- **Min/Max Response Time (Thời gian phản hồi tối thiểu/tối đa)**: 210 / 890 ms
- **Error Rate (Tỷ lệ lỗi)**: 0%
- **Throughput (Thông lượng)**: 5.2 requests/giây

#### 8.2. Thread Group 2: Kịch bản tải nặng
- **Samples (Mẫu)**: 100
- **Average Response Time (Thời gian phản hồi trung bình)**: 730 ms
- **Min/Max Response Time (Thời gian phản hồi tối thiểu/tối đa)**: 320 / 1580 ms
- **Error Rate (Tỷ lệ lỗi)**: 1%
- **Throughput (Thông lượng)**: 18.4 requests/giây

#### 8.3. Thread Group 3: Kịch bản tùy chỉnh
- **Samples (Mẫu)**: 240
- **Average Response Time (Thời gian phản hồi trung bình)**: 610 ms
- **Min/Max Response Time (Thời gian phản hồi tối thiểu/tối đa)**: 250 / 1320 ms
- **Error Rate (Tỷ lệ lỗi)**: 0%
- **Throughput (Thông lượng)**: 4.0 requests/giây

### 9. Phân tích và So sánh

#### 9.1. So sánh Response Time (Thời gian phản hồi)
- Thời gian phản hồi tăng từ 420 ms (TG1) lên 730 ms (TG2) khi tải cao; TG3 ổn định quanh 610 ms dù duyệt đa trang.

#### 9.2. So sánh Throughput (Thông lượng)
- Throughput cao nhất ở TG2 (18.4 req/s) do nhiều user đồng thời; TG1 5.2 req/s; TG3 ~4.0 req/s do kịch bản chạy theo thời lượng.

#### 9.3. Tỷ lệ Lỗi (Error Rate)
- TG1 và TG3: 0% lỗi; TG2: 1% lỗi dưới tải nặng, cần theo dõi thêm.

### 10. Kết luận

#### 10.1. Đánh giá Tổng quan
- Website chịu tải tốt ở mức cơ bản và kịch bản duyệt trang; dưới tải nặng response time tăng nhưng vẫn < 2 giây, lỗi chỉ 1%.

#### 10.2. Điểm Mạnh
- Tỷ lệ lỗi rất thấp (0–1%)
- Throughput tăng tốt khi user cao (TG2)
- Response time ổn định ở kịch bản duyệt trang (TG3)

#### 10.3. Điểm Cần Cải thiện
- Tối ưu response time dưới tải nặng (mục tiêu < 600 ms)
- Giảm độ lệch Min/Max ở TG2 để tránh spike ~1.5s

#### 10.4. Khuyến nghị
- Bật caching và tối ưu truy vấn nặng ở trang chủ/tìm kiếm
- Cân nhắc CDN cho tài nguyên tĩnh để giảm tải origin
- Theo dõi thêm lỗi 1% ở TG2 và kiểm tra log backend

### 11. Minh chứng hoàn thành

- Summary Report TG1: ![Summary TG1](Cypress/img/jmeter1.png)
- Summary Report TG2: ![Summary TG2](Cypress/img/jmeter2.png)
- Summary Report TG3: ![Summary TG3](Cypress/img/jmeter3.png)
- View Results Tree (mẫu request): ![View Results Tree](Cypress/img/jmeter4.png)
- Runner tổng quan/phiên bản: ![Runner Overview](Cypress/img/jmeter5.png)

### 12. Nhận xét và đánh giá

Thông qua bài tập này, em:
- Hiểu được cách sử dụng JMeter để kiểm thử hiệu năng website
- Biết cách thiết kế kịch bản kiểm thử với các tham số khác nhau (số lượng người dùng, thời gian chạy, hành vi người dùng)
- Hiểu được các chỉ số quan trọng trong kiểm thử hiệu năng: Response Time (thời gian phản hồi), Throughput (thông lượng), Error Rate (tỷ lệ lỗi)
- Biết cách phân tích và so sánh kết quả kiểm thử
- Rèn luyện kỹ năng viết báo cáo kiểm thử hiệu năng

Bài tập có tính thực tiễn cao, giúp em hiểu rõ hơn về tầm quan trọng của kiểm thử hiệu năng trong quá trình phát triển phần mềm.

### 13. Tài liệu tham khảo

- JMeter Official Documentation: https://jmeter.apache.org/usermanual/
- JMeter Best Practices: https://jmeter.apache.org/usermanual/best-practices.html
- Performance Testing Guide: https://jmeter.apache.org/usermanual/test_plan.html

### 14. Lưu ý quan trọng

1. **Không chạy test trên production (môi trường sản xuất)** nếu không được phép từ chủ sở hữu website
2. **Giới hạn số lượng request (yêu cầu)** để tránh làm quá tải server (máy chủ) và ảnh hưởng đến người dùng thật
3. **Chạy test vào giờ thấp điểm** để giảm ảnh hưởng đến người dùng thật
4. **Sử dụng non-GUI mode (chế độ không giao diện đồ họa)** cho test lớn (tiết kiệm tài nguyên và nhanh hơn)
5. **Lưu kết quả** để phân tích sau (file CSV - Comma Separated Values, HTML report - báo cáo HTML, screenshot - ảnh chụp màn hình)

### 15. Cam kết

Em xin cam kết kết quả trên là **do chính em thực hiện**, không sao chép và không sử dụng bất kỳ hình thức gian lận nào.

**Sinh viên thực hiện**  
Nguyễn Đức Anh

---


