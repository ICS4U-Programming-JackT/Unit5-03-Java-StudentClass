public class Student {
    /** First name field. */
    private String fName = "";
    /** Middle name field. */
    private String mName = "";
    /** Last name field. */
    private String lName = "";
    /** Grade field. */
    private int grade = 1;
    /** IEP field. */
    private boolean hasIEP = false;

    /** Middle name-less constructor.
     * @param firstName
     * @param lastName
     * @param gradeNum
     * @param stuHasIEP
    */
    public Student(final String firstName, final String lastName,
                final int gradeNum, final boolean stuHasIEP) {
        this.fName = firstName;
        this.lName = lastName;
        this.grade = gradeNum;
        this.hasIEP = stuHasIEP;
    }

    /** Middle name overload.
     * @param firstName
     * @param middleName
     * @param lastName
     * @param gradeNum
     * @param stuHasIEP
    */
    public Student(final String firstName, final String middleName,
            final String lastName, final int gradeNum,
            final boolean stuHasIEP) {
        this.fName = firstName;
        this.mName = middleName;
        this.lName = lastName;
        this.grade = gradeNum;
        this.hasIEP = stuHasIEP;
    }

    /**
     * Return student info as sentence.
     * @return Formatted string
     */
    public String getStudentInfo() {
        // Return formatted student info
        String fullName;

        // Case for middle name
        if (mName.isEmpty()) {
            fullName = fName + " " + lName;
        } else {
            fullName = fName + " " + mName + " " + lName;
        }

        // Return formatted
        return "Name: " + fullName + ", Grade: "
        + grade + ", Has IEP: " + hasIEP;
    }
}
