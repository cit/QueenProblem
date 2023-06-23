import java.util.ArrayList;

class QueenProblem {

    public static void permute(ArrayList<Integer> result, ArrayList<Integer> options) {
        if (!checkDiagonalRuleViolation(result)) {
            return;
        }

        if (options.size() == 0) {
            System.out.println(result);
        }

        for (int i = 0; i < options.size(); i++) {
            ArrayList<Integer> newResults = new ArrayList<Integer>(result);
            ArrayList<Integer> newOptions = new ArrayList<Integer>(options);

            newResults.add(newOptions.remove(i));
            permute(newResults, newOptions);
        }
    }

    public static boolean checkDiagonalRuleViolation(ArrayList<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            int value_i = result.get(i);

            int x = 1;
            for (int y = i+1; y < result.size(); y++) {
                int value_y = result.get(y);

                if (value_y == (value_i - x)) {
                    return false;
                }

                if (value_y == (value_i + x)) {
                    return false;
                }

                x++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArrayList<Integer> chars = new ArrayList<Integer>();
        int n = 13;

        for (int i = 0; i < n; i++)
            chars.add(i);

        permute(new ArrayList<Integer>(), chars);

    }
}
