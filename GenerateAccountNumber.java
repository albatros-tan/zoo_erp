import java.util.Random;

public class GenerateAccountNumber implements IGenerateAccNumber {

    @Override
    public String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(AccountConstants.ACCOUNT_NUMBER_LENGTH);
        for (int i = 0; i < AccountConstants.ACCOUNT_NUMBER_LENGTH; i++) {
            int index = random.nextInt(AccountConstants.CHARACTERS.length());
            sb.append(AccountConstants.CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

}
