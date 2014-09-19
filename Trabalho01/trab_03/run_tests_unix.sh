EUPHORIA_PATH=meuphoriaLex/
echo -e "---------------------------------\n"
echo -e "Acessando path $EUPHORIA_PATH onde está o analisador léxico\n"
cd $EUPHORIA_PATH
echo -e "Removendo arquivos desatualizados\n"
rm *.class
echo -e "Rodando Javacc: \n"
java -cp ../javacc.jar javacc meuphoria.jj
echo -e "Compilando .java files\n"
javac *.java
echo -e "---------------------------------\n"
echo -e "Rodando testes\n"

rm -R ../test_cases/resultados
mkdir ../test_cases/resultados
mkdir ../test_cases/resultados/happy_path
mkdir ../test_cases/resultados/sad_path

for teste in ../test_cases/happy_path/*.in
do
    result_path=${teste/happy_path/resultados\/happy_path}
    out_path=${result_path%.in}.out
    echo -e "Rodando ${teste/*teste/teste} - Happy path..."
    java Meuphoria < $teste > $out_path
    echo -e "Resultado salvo em $out_path.\n"
done

for teste in ../test_cases/sad_path/*.in
do
    result_path=${teste/sad_path/resultados\/sad_path}
    out_path=${result_path%.in}.out
    echo -e "Rodando ${teste/*teste/teste} - Sad path..."
    java Meuphoria < $teste > $out_path
    echo -e "Resultado salvo em $out_path.\n"
done