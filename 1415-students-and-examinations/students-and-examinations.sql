SELECT
    s.student_id,
    s.student_name,
    sub.subject_name,
    COUNT(exam.subject_name) AS attended_exams
FROM Students AS s
CROSS JOIN Subjects AS sub
LEFT JOIN Examinations AS exam
ON s.student_id=exam.student_id AND sub.subject_name=exam.subject_name
GROUP BY s.student_id,s.student_name,sub.subject_name
ORDER BY s.student_id,sub.subject_name;
