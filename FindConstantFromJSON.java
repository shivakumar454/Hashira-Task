// import java.io.FileReader;
// import java.util.*;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;

// public class FindConstantFromJSON {


//     public static long decodeY(int base, String value) {
//         return Long.parseLong(value, base);
//     }


//     public static double determinant(double[][] m) {
//         return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
//              - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
//              + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
//     }

//     public static void main(String[] args) {
//         if (args.length < 1) {
//             System.out.println("Please provide JSON file path as argument");
//             return;
//         }

//         try {
//             
//             JSONParser parser = new JSONParser();
//             JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(args[0]));

//             JSONObject keysObj = (JSONObject) jsonObject.get("keys");
//             long n = (long) keysObj.get("n");
//             long k = (long) keysObj.get("k");

//            
//             double[][] points = new double[(int) k][2];
//             int idx = 0;

//             for (Object key : jsonObject.keySet()) {
//                 String keyStr = key.toString();
//                 if (keyStr.equals("keys")) continue; // skip metadata

//                 if (idx < k) {
//                     JSONObject rootObj = (JSONObject) jsonObject.get(keyStr);
//                     int base = Integer.parseInt((String) rootObj.get("base"));
//                     String value = (String) rootObj.get("value");

//                     long decodedY = decodeY(base, value);
//                     points[idx][0] = Double.parseDouble(keyStr); // x value from key
//                     points[idx][1] = decodedY;
//                     idx++;
//                 }
//             }

//            
//             if (k != 3) {
//                 System.out.println("This example code currently supports only k=3 (quadratic).");
//                 return;
//             }

//             double x1 = points[0][0], y1 = points[0][1];
//             double x2 = points[1][0], y2 = points[1][1];
//             double x3 = points[2][0], y3 = points[2][1];

//             double[][] mat = {
//                 {x1 * x1, x1, 1},
//                 {x2 * x2, x2, 1},
//                 {x3 * x3, x3, 1}
//             };

//             double det = determinant(mat);

//             double[][] matA = {
//                 {y1, x1, 1},
//                 {y2, x2, 1},
//                 {y3, x3, 1}
//             };
//             double a = determinant(matA) / det;

//             double[][] matB = {
//                 {x1 * x1, y1, 1},
//                 {x2 * x2, y2, 1},
//                 {x3 * x3, y3, 1}
//             };
//             double b = determinant(matB) / det;

//             double[][] matC = {
//                 {x1 * x1, x1, y1},
//                 {x2 * x2, x2, y2},
//                 {x3 * x3, x3, y3}
//             };
//             double c = determinant(matC) / det;

//            
//             System.out.println(c);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }   
// }



 
