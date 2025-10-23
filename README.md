# Android Task — Ibrahim Jamil

This project was developed by **Ibrahim Jamil** as part of an Android development task.  
It showcases essential Android development concepts including UI design, data persistence, and modern app architecture using **Kotlin** and **MVVM**.

---

## 📱 Overview

The app demonstrates how to build a clean, well-structured Android application following best practices such as the **MVVM architecture**, **Room database**, and **Kotlin Coroutines** for background operations.  

---

## 🧩 App Structure

```
android-task-Ibrahim-Jamil/
│
├── .idea/ # Android Studio project settings
│
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/androidtask/
│ │ │ │ ├── data/
│ │ │ │ │ ├── local/
│ │ │ │ │ │ ├── entity/ # Data entities representing database tables
│ │ │ │ │ │ ├── dao/ # Data Access Objects (Room DAO interfaces)
│ │ │ │ │ │ └── AppDatabase.kt # Main Room database class
│ │ │ │ │ └── repository/ # Repository layer connecting data sources
│ │ │ │ ├── ui/
│ │ │ │ │ ├── activities/ # Activities that represent app screens
│ │ │ │ │ ├── adapter/ # RecyclerView Adapters
│ │ │ │ │ ├── viewmodel/ # ViewModels handling business logic
│ │ │ │ └── utils/ # Utility classes and helpers
│ │ │ ├── res/ # Layouts, drawables, strings, etc.
│ │ │ └── AndroidManifest.xml
│ │
│ ├── build.gradle.kts
│ └── proguard-rules.pro
│
├── gradle/ # Gradle wrapper files
├── screenshots/ # App screenshots (to be added)
├── build.gradle.kts # Project-level Gradle configuration
├── settings.gradle.kts
└── gradle.properties

```

---

## 🧰 Technologies & Tools

- **Language:** Kotlin  
- **Architecture:** MVVM  
- **Database:** Room Persistence Library  
- **Asynchronous Processing:** Kotlin Coroutines  
- **Reactive Updates:** LiveData  
- **UI Design:** XML Layouts  
- **Build System:** Gradle  

---

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   
   git clone https://github.com/ibrahimjamil301/android-task-Ibrahim-Jamil.git

   ```
2. Open the project in **Android Studio**.  
3. Wait for Gradle to finish syncing and downloading all dependencies.  
4. Connect your Android device or start an emulator.  
5. Click **Run ▶️** or execute the following command in the terminal:
   
   ```bash
   
   ./gradlew installDebug
   
   ```
---

## 🖼️ Screenshots

| Home Screen | Plan Selected Screen |
|--------------|----------------------|
| <img width="418" height="847" alt="Home Screen" src="https://github.com/user-attachments/assets/9a8d8ca4-7965-40d0-8ee4-08a176e67432" /> | <img width="389" height="859" alt="Plan Selected Screen" src="https://github.com/user-attachments/assets/88129c40-b759-43ce-8ef2-19d572c14da0" /> |

| Plan Selected1 Screen | Filtering Screen |
|------------------------|------------------|
| <img width="406" height="853" alt="Plan Selected1 Screen" src="https://github.com/user-attachments/assets/f4ce0f44-24eb-4b95-9151-b2da77b4d4f7" /> | <img width="419" height="841" alt="Filtering Screen" src="https://github.com/user-attachments/assets/91c6c0d5-772d-4d64-8135-20373207989a" /> |

| Filtering1 Screen |
|-------------------|
| <img width="398" height="840" alt="Filtering1 Screen" src="https://github.com/user-attachments/assets/ae2972b2-af33-4957-8410-9caf9c6d2534" /> |

---

## 🌟 Features

- Store data locally using **Room Database**  
- Follow the **MVVM** architecture for clean separation of concerns  
- Perform background operations using **Coroutines**  
- Observe live data changes through **LiveData**  
- User-friendly and responsive UI built with **XML layouts**
  
---

## 👤 Author

**Ibrahim Jamil**  
📍 Cairo, Egypt  
💻 Android Developer passionate about building clean, scalable, and user-friendly mobile apps.  
📧 [ibrahimjamil301@gmail.com](mailto:ibrahimjamil301@gmail.com)


---

## 📝 License

This project is created for **educational purposes only** and is not licensed for commercial use.

