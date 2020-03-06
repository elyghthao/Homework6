import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private HashMap<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
    private void index(List<String> texts) {
        //homework
        indexes = new HashMap<String, List<List<Integer>>>();
        List<List<Integer>> yes = new ArrayList<List<Integer>>();
        yes.add(new ArrayList<Integer>(Arrays.asList(1,2,3))) ;
        yes.add(new ArrayList<Integer>(Arrays.asList(1,2,3))) ;
        List<List<Integer>> bye = new ArrayList<List<Integer>>();
        bye.add(new ArrayList<Integer>(Arrays.asList(1,2,3))) ;
        bye.add(new ArrayList<Integer>(Arrays.asList(1,2,3))) ;
//        indexes.put("bye",bye);
//        indexes.put("hello", yes);

//        for (int i =0;i<texts.size();i++) {
//            indexes.
//        }


//        System.out.println(indexes.get("hello"));
//        System.out.println(indexes.containsKey("hello"));



        for (int i = 0; i<texts.size();i++) {
//            System.out.println(texts.get(i));
            String [] words = texts.get(i).split(" ");
//            System.out.println(Arrays.toString(words));
            for (int j=0;j<words.length;j++) {//this traverses words array of strings
                if (indexes.containsKey(words[j])) {
//                    System.out.print("found value is: " + words[j]);
//                    System.out.print("true, index: " + j) ;
                }else {
                    List<List<Integer>> temporary = new ArrayList<List<Integer>>();
                    for(int t = 0; t<texts.size();t++) {
                        temporary.add(new ArrayList<Integer>()) ;
                    }
                    indexes.put(words[j],temporary);
                }
                indexes.get(words[j]).get(i).add(j);
            }
//            System.out.println("\n");

        }
        System.out.println(indexes) ;


    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        HashMap<Integer, List<List<Integer>>> documents = new HashMap<Integer, List<List<Integer>>>();
        String [] words = keyPhrase.toLowerCase().split(" ");
        System.out.println(Arrays.toString(words));
        List<List<Integer>> list;

        List<Integer> sameDocs = new ArrayList<>();


        for(int i = 0; i< words.length;i++) {//traverse from each word to word
            if (indexes.containsKey(words[i])) {
                List<List<Integer>> temporary = new ArrayList<List<Integer>>();
                for (int j = 0; j<indexes.get(words[i]).size();j++) {//traverse each element in documents
                     list = new ArrayList<>();
                        list.add(indexes.get(words[i]).get(j));
//                        documents.put(i,temporary);
//                        System.out.println(list);
                        temporary.add(list.get(0));
                }
                documents.put(i,temporary);
            }
        }
        System.out.println(documents);
//        System.out.println(documents.get(0).size());

        for (int i = 0;i<documents.get(0).size();i++) {
            System.out.println(i);
        }



//        indexes.forEach((k,v)-> {//traverses the entire indexes
//            System.out.println(k + " " +v.size());
//                });



        return new ArrayList<>(); // place holder
    }
}
