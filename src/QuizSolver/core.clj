(ns QuizSolver.core
  (use [clojure.pprint]
       [clojure.java.io :only [reader]]))

'(Solver
 #{"N"  "a" "b"}
 #{"i"  }
 #{"e" }
 #{"d"  "a" "b"}
 #{"e" }
 #{"r"  "a" "b"}
 #{"g" }
 #{"a" }
 #{"n" }
 #{"g"  "a" "b"})

(defn DicCuter []
  (let [wordlst (line-seq (reader "worte.dic"))]
    (spit "worte.dic"
          (map (fn [word]
                 (take-while #(not= \/ %) (seq word)))
               wordlst))))


(defn RealWord? [word]
  (let [wordlst (line-seq (reader "worte.dic"))]
    (first
     (drop-while nil?
                 (doseq [dicword wordlst]
                   (when (= dicword word)
                     word))))))

(defn Solver [s0 s1 s2 s3 s4 s5 s6 s7 s8 s9]
  (for [i0 s0, i1 s1, i2 s2, i3 s3, i4 s4,
        i5 s5, i6 s6, i7 s7, i8 s8, i9 s9]
    (RealWord? (apply str [i0 i1 i2 i3 i4 i5 i6 i7 i8 i9]))))
