package library;

import java.time.LocalDate;

public class Faculty extends MemberRecord{
    private String department;

    public Faculty(int memberId, String type, LocalDate dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo, String department) {
        super(memberId, type, dateOfMembership, noBooksIssued, maxBookLimit, name, address, phoneNo);
        this.department = department;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + " Department: " + department;
    }
}
