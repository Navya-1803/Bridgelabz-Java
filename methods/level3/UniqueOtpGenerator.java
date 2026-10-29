package level3;

import java.util.Arrays;

public class UniqueOtpGenerator {

    // Generate a six-digit OTP from 100000 through 999999
    public static int generateOtp() {
        return (int) (Math.random() * 900000) + 100000;
    }

    // Return true if every OTP in the array is unique
    public static boolean areOtpsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Generate the requested number of unique OTPs
    public static int[] generateUniqueOtps(int size) {
        int[] otps = new int[size];
        int count = 0;

        while (count < size) {
            int otp = generateOtp();
            boolean isDuplicate = false;

            // Check the new OTP against previously stored OTPs
            for (int i = 0; i < count; i++) {
                if (otps[i] == otp) {
                    isDuplicate = true;
                    break;
                }
            }

            // Store only a unique OTP
            if (!isDuplicate) {
                otps[count] = otp;
                count++;
            }
        }

        return otps;
    }

    public static void main(String[] args) {
        int[] otps = generateUniqueOtps(10);

        System.out.println("Generated OTPs:");
        System.out.println(Arrays.toString(otps));

        System.out.println("All OTPs are unique: "
                + areOtpsUnique(otps));
    }
}
