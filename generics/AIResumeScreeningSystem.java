import java.util.ArrayList;
import java.util.List;

public class AIResumeScreeningSystem {

    // Abstract job role
    static abstract class JobRole {
        private String roleName;

        JobRole(String roleName) {
            this.roleName = roleName;
        }

        String getRoleName() {
            return roleName;
        }

        abstract int getRequiredScore();
    }

    static class SoftwareEngineer extends JobRole {
        SoftwareEngineer() {
            super("Software Engineer");
        }

        int getRequiredScore() {
            return 75;
        }
    }

    static class DataScientist extends JobRole {
        DataScientist() {
            super("Data Scientist");
        }

        int getRequiredScore() {
            return 80;
        }
    }

    static class ProductManager extends JobRole {
        ProductManager() {
            super("Product Manager");
        }

        int getRequiredScore() {
            return 70;
        }
    }

    // Generic resume class
    static class Resume<T extends JobRole> {
        private String candidateName;
        private T jobRole;
        private int skillScore;

        Resume(String candidateName, T jobRole, int skillScore) {
            this.candidateName = candidateName;
            this.jobRole = jobRole;
            this.skillScore = skillScore;
        }

        String getCandidateName() {
            return candidateName;
        }

        T getJobRole() {
            return jobRole;
        }

        int getSkillScore() {
            return skillScore;
        }
    }

    // Generic method for screening resumes
    static <T extends JobRole> void screenResume(Resume<T> resume) {
        int requiredScore = resume.getJobRole().getRequiredScore();

        System.out.println("\nCandidate: "
                + resume.getCandidateName());

        System.out.println("Applied Role: "
                + resume.getJobRole().getRoleName());

        System.out.println("Skill Score: "
                + resume.getSkillScore());

        if (resume.getSkillScore() >= requiredScore) {
            System.out.println("Result: Shortlisted");
        } else {
            System.out.println("Result: Rejected");
        }
    }

    // Wildcard method for processing multiple job roles
    static void screenAllResumes(
            List<? extends Resume<? extends JobRole>> resumes) {

        System.out.println("--- Resume Screening Pipeline ---");

        for (Resume<? extends JobRole> resume : resumes) {
            screenResume(resume);
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> resume1 =
                new Resume<>(
                        "Alice",
                        new SoftwareEngineer(),
                        90
                );

        Resume<DataScientist> resume2 =
                new Resume<>(
                        "Bob",
                        new DataScientist(),
                        75
                );

        Resume<ProductManager> resume3 =
                new Resume<>(
                        "Carol",
                        new ProductManager(),
                        85
                );

        Resume<SoftwareEngineer> resume4 =
                new Resume<>(
                        "David",
                        new SoftwareEngineer(),
                        65
                );

        // Store resumes for different job roles
        List<Resume<? extends JobRole>> resumes =
                new ArrayList<>();

        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);
        resumes.add(resume4);

        screenAllResumes(resumes);
    }
}