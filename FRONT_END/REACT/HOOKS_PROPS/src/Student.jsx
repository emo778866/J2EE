import React, { useState } from "react";
import "./Student.css";

function Student({ studentName, studentId }) {
  const [name, setName] = useState("Student Name");
  const [id, setId] = useState("Student Id");

  function setDetails() {
    setName(studentName);
    setId(studentId);
  }

  return (
    <div className="student-card">
      <h2>{name}</h2>
      <h2>{id}</h2>
      <button className="updateButton" onClick={setDetails}>
        Show Details
      </button>
    </div>
  );
}

export default Student;
