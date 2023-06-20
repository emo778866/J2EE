import Header from "./Header";
import Footer from "./Footer";
import "./App.css";
import Student from "./Student";

function App() {
  const studentInformation = [
    { studentId: 1, studentName: "Mehedi Hasan" },
    { studentId: 2, studentName: "Khalid Saifullah" },
    { studentId: 3, studentName: "Al Amin Patwary" },
  ];

  return (
    <>
      <Header />
      <div className="main">
        {studentInformation.map((student) => (
          <Student
            studentName={student.studentName}
            studentId={student.studentId}
          />
        ))}
      </div>
      <Footer />
    </>
  );
}

export default App;
