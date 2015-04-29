public class Solution {
     
    HashMap<String, String> err = new HashMap<String, String>();

    public void addErr(String s, String p)
    {
        if(err.containsKey(s) && p.equals(err.get(s)) )
            return;
        
        err.put(s,p);

    }

    public boolean match(String s,String p)
    {
        if(err.containsKey(s) && p.equals(err.get(s)))
            return false;
        return true;
    }

    public boolean process(String s, String p) {
 		System.out.println(s);
 		System.out.println(p);
 		
 		int lens = s.length();
 		int lenp = p.length();

 		if(lens == 0){
 			return true;
 		}

 		if(lenp == 0){
 			return lens == 0;
 		}
        
        if(!match(s,p)){
            return false;
        }
 		
        if(lens == 1){
 			if(p.charAt(0) == '.' || s.equals(p.substring(0,1)) || (lenp==1 &&p.charAt(0) == '*') ){
                return true;
            }else{
                addErr(s,p);
                return false;
            } 
 		}

 		if(lenp == 1){
 			if( (p.equals(".")&&lens == 1) || p.equals("*") || p.equals(s)){
 				return true;
 			}else{
                addErr(s,p);
 				return false;
 			}
 		}

 		if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)){
 			if( !match(s.substring(1), p.substring(1))){
                addErr(s,p);
                return false;
            }else if(process( s.substring(1), p.substring(1)) ){
 				return true;
 			}else{
                addErr(s, p.substring(1));
                addErr(s.substring(1),p.substring(1));
 				if(!match(s,p.substring(1))){
                    addErr(s,p);
                    return false;
                }else if( process(s,p.substring(1)) ){
                    return true;
                }else{ 
                    addErr(s,p.substring(1));
                    addErr(s,p);
                    return false;
                }
            }
 		}
        
 		if(p.charAt(0) == '*'){
 			for(int i=lens-1;i>=0;i--){
                if(lenp == 2 && !p.substring(1).equals("*")){
                    if( s.substring(lens-1,lens).equals(p.substring(1)) ){
                        return true;
                    }else{
                        addErr(s,p);
                        return false;
                    }
                }

 				if( (p.charAt(1) == s.charAt(i) || p.charAt(1) == '.') ){
 				    if(!match(s.substring(i), p.substring(1)) ){
                        return false;
                    }else if(process(s.substring(i),p.substring(1)) ){
 					  return true;
                    }else{
                        for(int j=0;j<=i;j++){
                            addErr(s.substring(j),p.substring(1));
                        }
                        //addErr(s.substring(i),p.substring(1));
                    }
                }
 			}
            addErr(s,p);
 			return false;
 		}

 		if(match(s,p.substring(1)) && process(s,p.substring(1))){
            return true;
        }else{
            addErr(s,p.substring(1));
            addErr(s,p);
            return false;
        }   
    }

    public boolean isMatch(String s, String p)
    {
        if(s.length() == 0){
    		return true;
    	}

    	if(p.length() == 0){
 			return s.length() == 0;
 		}

    	for(int i=0;i<p.length();i++){
    		if( (s.charAt(0) == p.charAt(i) || p.charAt(i) == '.') 
    			&& match(s.substring(1),p.substring(i+1))){

                if( process(s.substring(1), p.substring(i+1)) ){
                    return true;
                }else{
                    addErr(s.substring(1), p.substring(i+1));
                }
    		}
    	}
    	return false;
    }

}