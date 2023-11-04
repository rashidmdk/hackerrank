public class CheckArraySimilarity {

    public static void main(String[] args) {

        int[] inputArrayOne = {1,5,7,9,15};
        int[] inputArrayTwo = {1,5,9,11,15};

        int[] inputArraythree = { 1,10,14,20,29,58,39};
        int[] inputArrayfour = { 1,10,15,22,29,58,39};

        String similarity1 = canArraysBeIdentical(5, inputArrayOne, inputArrayTwo);
        String similarity11 = canArraysBeIdentical(7, inputArraythree, inputArrayfour);
        System.out.println("Arrays similarity1: " + similarity1);
        System.out.println("Arrays similarity11: " + similarity11);



    }

    public static String canArraysBeIdentical(int N, int[] inputArrayOne, int[] inputArrayTwo) {
        // Check if the arrays are already identical
        boolean alreadyIdentical = true;
        for (int i = 0; i < N; i++) {
            if (inputArrayOne[i] != inputArrayTwo[i]) {
                alreadyIdentical = false;
                break;
            }
        }
        if (alreadyIdentical) {
            return "yes";
        }

        // Try adding val to elements in inputArrayOne from index l to r
        for (int l = 1; l <= N; l++) {
            for (int r = l; r <= N; r++) {
                for (int val = 1; val <= 100; val++) {
                    // Create a temporary array to check if the operation would make the arrays identical
                    int[] tempArray = new int[N];
                    System.arraycopy(inputArrayOne, 0, tempArray, 0, N);
                    for (int i = l - 1; i < r; i++) {
                        tempArray[i] += val;
                    }
                    boolean identical = true;
                    for (int i = 0; i < N; i++) {
                        if (tempArray[i] != inputArrayTwo[i]) {
                            identical = false;
                            break;
                        }
                    }
                    if (identical) {
                        return "yes";
                    }
                }
            }
        }
        return "no";
    }

//    The above fucntion in Typescript 4.3.4

//    export default function arraySimilarity(N: number, inputArrayOne: number[], inputArrayTwo: number[]): string {
//  const c = [];
//        let cnt = 1;
//
//        for (let i = 0; i < N; i++) {
//            c[i] = inputArrayTwo[i] - inputArrayOne[i];
//        }
//
//  const ans = [];
//
//        for (let i = 0; i < N; i++) {
//            if (c[i] === c[i + 1]) {
//                cnt++;
//            } else {
//                ans.push([c[i], cnt]);
//                cnt = 1;
//            }
//        }
//
//        ans.push([c[c.length - 1], cnt]);
//
//        if (ans.length <= 3) {
//            if (ans.length === 1) {
//                return 'Yes';
//            } else if (ans[0][0] === 0 && ans[2][0] === 0 && ans[1][0] > 0) {
//                return 'Yes';
//            } else {
//                return 'No';
//            }
//        } else {
//            return 'No';
//        }
//    }

}
