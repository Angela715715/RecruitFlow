# RecruitFlow
# RecruitFlow 招募管理系統

RecruitFlow 是一個使用 **Java Swing + MySQL + JDBC** 開發的桌面版招募管理系統，主要提供公司內部管理員、HR 與主管使用。

系統可管理使用者帳號、部門、職缺與候選人資料，並依照不同角色限制可操作的功能權限。

---

## 專案特色

* Java Swing 視窗化介面
* Maven 專案管理
* MySQL 資料庫串接
* JDBC 操作資料庫
* DAO / Service 分層架構
* JTable 顯示資料列表
* JComboBox 下拉選單
* 部門與職缺連動選單
* 角色權限控管
* 候選人面試評價與狀態管理

---

## 使用技術

| 技術             | 說明              |
| -------------- | --------------- |
| Java           | 主要開發語言          |
| Swing / JFrame | 桌面視窗介面          |
| WindowBuilder  | Swing UI 設計工具   |
| Maven          | 專案與套件管理         |
| MySQL          | 資料庫             |
| JDBC           | Java 與 MySQL 連線 |
| DAO / Service  | 專案分層架構          |

---

## 系統功能

### 1. 登入系統

使用者需輸入帳號與密碼登入系統。

登入成功後，系統會依照使用者角色導向不同主畫面。

目前系統角色分為：

| 角色      | 說明  |
| ------- | --- |
| ADMIN   | 管理員 |
| HR      | 人資  |
| MANAGER | 主管  |

---

### 2. 帳號管理

帳號管理僅提供 **ADMIN 管理員** 使用。

功能包含：

* 新增帳號
* 修改帳號
* 刪除帳號
* 查詢帳號列表
* 設定使用者角色

為確保系統資料安全，避免未授權人員存取內部招募資料，本系統不開放一般使用者自行註冊帳號。
所有使用者帳號皆須由管理員建立與管理，並依照角色分配對應權限。

---

### 3. 部門管理

部門管理提供 **ADMIN** 與 **HR** 使用。

功能包含：

* 新增部門
* 修改部門
* 刪除部門
* 查詢部門列表

---

### 4. 職缺管理

職缺管理提供 **ADMIN** 與 **HR** 使用。

功能包含：

* 新增職缺
* 修改職缺
* 刪除職缺
* 查詢職缺列表
* 職缺狀態管理

職缺狀態包含：

| 狀態     | 說明  |
| ------ | --- |
| OPEN   | 開放中 |
| CLOSED | 已關閉 |

---

### 5. 候選人管理

候選人管理為本系統主要功能之一。

功能包含：

* 新增候選人
* 修改候選人資料
* 刪除候選人
* 查詢候選人列表
* 面試評價管理
* 面試結果管理
* 候選人狀態管理
* 應徵部門與應徵職缺連動選單

在候選人管理畫面中，選擇「應徵部門」後，「應徵職缺」下拉選單會自動顯示該部門底下的職缺。

---

## 角色權限說明

| 功能        | ADMIN 管理員 | HR 人資 | MANAGER 主管 |
| --------- | --------- | ----- | ---------- |
| 帳號管理      | 可使用       | 不可使用  | 不可使用       |
| 部門管理      | 可使用       | 可使用   | 不可使用       |
| 職缺管理      | 可使用       | 可使用   | 不可使用       |
| 候選人查詢     | 可使用       | 可使用   | 可使用        |
| 候選人新增     | 可使用       | 可使用   | 不可使用       |
| 候選人刪除     | 可使用       | 可使用   | 不可使用       |
| 候選人基本資料修改 | 可使用       | 可使用   | 不可使用       |
| 面試評價修改    | 可使用       | 可使用   | 可使用        |
| 面試結果修改    | 可使用       | 可使用   | 可使用        |
| 候選人狀態修改   | 可使用       | 可使用   | 可使用        |

---

## 測試帳號

| 角色         | 帳號    | 密碼   | 權限說明                        |
| ---------- | ----- | ---- | --------------------------- |
| ADMIN 管理員  | admin | 1234 | 可管理帳號、部門、職缺與候選人資料           |
| HR 人資      | hr01  | 1234 | 可管理部門、職缺與候選人資料              |
| MANAGER 主管 | mg01  | 1234 | 可查看候選人資料，並修改面試評價、面試結果與候選人狀態 |

---

## 候選人狀態設計

### 面試結果 interview_result

| 狀態      | 說明    |
| ------- | ----- |
| PENDING | 尚未決定  |
| PASS    | 面試通過  |
| FAIL    | 面試未通過 |

### 候選人狀態 status

| 狀態        | 說明        |
| --------- | --------- |
| NEW       | 新候選人      |
| SCREENING | 履歷審核中     |
| INTERVIEW | 面試中       |
| ON_HOLD   | 暫緩        |
| REJECTED  | 未錄取       |
| OFFER     | 已發 Offer  |
| HIRED     | 已錄取 / 已到職 |

---

## 資料表設計

本系統主要使用以下資料表：

| 資料表        | 說明      |
| ---------- | ------- |
| member     | 使用者帳號資料 |
| department | 部門資料    |
| job        | 職缺資料    |
| candidate  | 候選人資料   |

---

## member 使用者資料表

| 欄位       | 說明    |
| -------- | ----- |
| id       | 使用者編號 |
| username | 帳號    |
| password | 密碼    |
| name     | 使用者姓名 |
| role     | 使用者角色 |

角色包含：

* ADMIN
* HR
* MANAGER

---

## department 部門資料表

| 欄位   | 說明   |
| ---- | ---- |
| id   | 部門編號 |
| name | 部門名稱 |

---

## job 職缺資料表

| 欄位            | 說明     |
| ------------- | ------ |
| id            | 職缺編號   |
| department_id | 所屬部門編號 |
| title         | 職缺名稱   |
| description   | 職缺描述   |
| status        | 職缺狀態   |

---

## candidate 候選人資料表

| 欄位               | 說明     |
| ---------------- | ------ |
| id               | 候選人編號  |
| name             | 候選人姓名  |
| phone            | 電話     |
| email            | Email  |
| job_id           | 應徵職缺編號 |
| interview_review | 面試評價   |
| interview_result | 面試結果   |
| status           | 候選人狀態  |

候選人資料透過 `job_id` 對應職缺，再透過職缺的 `department_id` 對應部門。

資料關係：

```text
candidate.job_id
        ↓
job.id
        ↓
job.department_id
        ↓
department.id
```

---

## 專案架構

```text
RecruitFlow
├── src/main/java
│   ├── controller
│   │   ├── Login.java
│   │   ├── LoginError.java
│   │   ├── AdminMainUI.java
│   │   ├── HRMainUI.java
│   │   ├── ManagerMainUI.java
│   │   ├── MemberTableUI.java
│   │   ├── AddMemberSuccess.java
│   │   ├── AddMemberError.java
│   │   ├── Department
│   │   │   ├── DepartmentTableUI.java
│   │   │   ├── AddDepartmentSuccess.java
│   │   │   └── AddDepartmentError.java
│   │   ├── Job
│   │   │   ├── JobTableUI.java
│   │   │   ├── AddJobSuccess.java
│   │   │   └── AddJobError.java
│   │   └── Candidate
│   │       ├── CandidateTableUI.java
│   │       ├── AddCandidateSuccess.java
│   │       └── AddCandidateError.java
│   │
│   ├── model
│   │   ├── Member.java
│   │   ├── Department.java
│   │   ├── Job.java
│   │   └── Candidate.java
│   │
│   ├── dao
│   │   ├── MemberDao.java
│   │   ├── DepartmentDao.java
│   │   ├── JobDao.java
│   │   └── CandidateDao.java
│   │
│   ├── dao.impl
│   │   ├── MemberDaoImpl.java
│   │   ├── DepartmentDaoImpl.java
│   │   ├── JobDaoImpl.java
│   │   └── CandidateDaoImpl.java
│   │
│   ├── service
│   │   ├── MemberService.java
│   │   ├── DepartmentService.java
│   │   ├── JobService.java
│   │   └── CandidateService.java
│   │
│   ├── service.impl
│   │   ├── MemberServiceImpl.java
│   │   ├── DepartmentServiceImpl.java
│   │   ├── JobServiceImpl.java
│   │   └── CandidateServiceImpl.java
│   │
│   └── util
│       └── DbConnection.java
│
├── mysql.sql
├── pom.xml
└── README.md
```

---

## 安裝與執行方式

### 1. 匯入 Maven 專案

使用 Eclipse 匯入專案：

```text
File → Import → Maven → Existing Maven Projects
```

選擇 `RecruitFlow` 專案資料夾後完成匯入。

---

### 2. 建立 MySQL 資料庫

先建立資料庫：

```sql
CREATE DATABASE RecruitFlow;
USE RecruitFlow;
```

---

### 3. 匯入資料表與測試資料

專案內提供：

```text
mysql.sql
```

可將此 SQL 檔匯入 MySQL，用來建立資料表與測試資料。

---

### 4. 修改資料庫連線設定

打開：

```text
src/main/java/util/DbConnection.java
```

確認資料庫連線資訊：

```java
String url = "jdbc:mysql://localhost:3306/RecruitFlow";
String username = "root";
String password = "1234";
```

請依照自己的 MySQL 帳號與密碼修改。

---

### 5. 執行系統

從以下檔案執行：

```text
src/main/java/controller/Login.java
```

執行方式：

```text
Run As → Java Application
```

---

## 系統畫面說明

### 登入頁面

* 使用帳號與密碼登入
* 依照角色進入不同主畫面
* 不提供自行註冊功能

### 管理員主畫面

ADMIN 可使用：

* 帳號管理
* 部門管理
* 職缺管理
* 求職者管理

### HR 主畫面

HR 可使用：

* 部門管理
* 職缺管理
* 求職者管理

### 主管主畫面

MANAGER 可使用：

* 求職者管理

MANAGER 僅能修改面試評價、面試結果與候選人狀態，無法新增或刪除候選人。

---

## 專案學習重點

此專案主要練習以下內容：

* Java 物件導向設計
* Swing / JFrame 視窗開發
* JTable 顯示資料
* JComboBox 下拉選單
* JDBC 資料庫連線
* PreparedStatement
* ResultSet
* MySQL CRUD
* SQL JOIN
* DAO / Service 分層架構
* Maven 專案管理
* 角色權限控制

---

## 未來可擴充功能

* 履歷檔案上傳
* 候選人搜尋功能
* 面試時間排程
* 匯出候選人資料
* 密碼加密
* 使用者操作紀錄
* 權限管理細分
* Web 版本系統

---

## GitHub 上傳注意事項

以下資料夾為編譯或 Eclipse 工作區產生的檔案，建議不要上傳到 GitHub：

```text
target/
.metadata/
```

建議可在 `.gitignore` 加入：

```gitignore
target/
.metadata/
.DS_Store
```

---

## 作者

此專案為 Java、Swing、MySQL、JDBC 與 Maven 的練習作品，主要用於學習招募管理系統的基本功能設計、資料庫串接與角色權限控管。
