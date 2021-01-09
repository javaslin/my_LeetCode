package leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {


    public static String simplifyPath(String path) {

        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <path.length(); i++) {
            if(path.charAt(i)==' ' ){
                continue;
            }
            if(path.charAt(i)=='/' && !stack.isEmpty()&&stack.peek()=='/'){
                continue;
            }
            stack.push(path.charAt(i));
        }
        if(!stack.isEmpty()&&stack.peek()=='/'){
            stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String newStr= sb.reverse().toString();
//        System.out.println("newStr"+newStr);
        String[] split = newStr.split("/");
//        Arrays.stream(split).forEach(num -> System.out.println(num));
        Stack<String> stringStack=new Stack<>();
        for (int i = 0; i <split.length ; i++) {
            if(split[i].equals(".") || split[i].trim().equals("")){
                continue;
            }
            if(split[i].equals("..")&&!stringStack.isEmpty()){
                stringStack.pop();
                continue;
            }
            if(split[i].equals("..")&&stringStack.isEmpty()){
                continue;
            }
            stringStack.push(split[i]);
        }
        StringBuilder stringBuilder=new StringBuilder();
//
//        while (!stringStack.isEmpty()){
////            System.out.println(stringStack.peek());
//
//
//
//        }
//        System.out.println("stringStack.size()"+stringStack.size());
        for (int i = 0; i <stringStack.size(); i++) {
            stringBuilder.append("/");
            stringBuilder.append(stringStack.get(i));
        }

        if(stringBuilder.length()>0&&stringBuilder.charAt(stringBuilder.length()-1)=='/'){
            return stringBuilder.substring(0,stringBuilder.length()-1);
        }

        return stringBuilder.length()>0?stringBuilder.toString():"/";



    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
