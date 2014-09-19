@echo Acessando a pasta do analisador lexico
@echo off
@echo.
cd ./meuphoriaLex
@echo Removendo arquivos desatualizados
@echo.
del *.class
@echo Rodando Javacc
@echo.
java -cp ../javacc.jar javacc meuphoriaLex.jj
@echo.
@echo Compilando .java files
@echo.
javac *.java
@echo --------------------------------------------
@echo Rodando os testes
@echo.

cd..
cd test_cases

rmdir resultados /S /Q
mkdir resultados
cd resultados
mkdir happy_path
mkdir sad_path
cd..
cd..

@echo Rodando o teste 01
java Meuphoria < ./test_cases/happy_path/teste01_comentario.in > ./test_cases/resultados/happy_path/teste01_comentario.out
@echo Rodando o teste 02
java Meuphoria < ./test_cases/happy_path/teste02_declarar_variaveis.in > ./test_cases/resultados/happy_path/teste02_declarar_variaveis.out
@echo Rodando o teste 03
java Meuphoria < ./test_cases/happy_path/teste03_atribuir_valores.in > ./test_cases/resultados/happy_path/teste03_atribuir_valores.out
@echo Rodando o teste 04
java Meuphoria < ./test_cases/happy_path/teste04_imprimir_variaveis.in > ./test_cases/resultados/happy_path/teste04_imprimir_variaveis.out
@echo Rodando o teste 05
java Meuphoria < ./test_cases/happy_path/teste05_chaves_sequencia.in > ./test_cases/resultados/happy_path/teste05_chaves_sequencia.out
@echo Rodando o teste 06
java Meuphoria < ./test_cases/happy_path/teste06_operadoresAritimeticos.in > ./test_cases/resultados/happy_path/teste06_operadoresAritimeticos.out
@echo Rodando o teste 07
java Meuphoria < ./test_cases/happy_path/teste07_operadoresLogicos.in > ./test_cases/resultados/happy_path/teste07_operadoresLogicos.out
@echo Rodando o teste 08
java Meuphoria < ./test_cases/happy_path/teste08_operadoresAtribuicao.in > ./test_cases/resultados/happy_path/teste08_operadoresAtribuicao.out
@echo Rodando o teste 09
java Meuphoria < ./test_cases/happy_path/teste09_if_statement.in > ./test_cases/resultados/happy_path/teste09_if_statement.out
@echo Rodando o teste 10
java Meuphoria < ./test_cases/happy_path/teste10_switch_statement.in > ./test_cases/resultados/happy_path/teste10_switch_statement.out
@echo Rodando o teste 11
java Meuphoria < ./test_cases/happy_path/teste11_while_statement.in > ./test_cases/resultados/happy_path/teste11_while_statement.out
@echo Rodando o teste 12
java Meuphoria < ./test_cases/happy_path/teste12_for_statement.in > ./test_cases/resultados/happy_path/teste12_for_statement.out
@echo Rodando o teste 13
java Meuphoria < ./test_cases/happy_path/teste13_flow_exit.in > ./test_cases/resultados/happy_path/teste13_flow_exit.out
@echo Rodando o teste 14
java Meuphoria < ./test_cases/happy_path/teste14_flow_break.in > ./test_cases/resultados/happy_path/teste14_flow_break.out
@echo Rodando o teste 15
java Meuphoria < ./test_cases/happy_path/teste15_flow_continue.in > ./test_cases/resultados/happy_path/teste15_flow_continue.out
@echo Rodando o teste 16
java Meuphoria < ./test_cases/happy_path/teste16_procedure.in > ./test_cases/resultados/happy_path/teste16_procedure.out
@echo Rodando o teste 17
java Meuphoria < ./test_cases/happy_path/teste17_function.in > ./test_cases/resultados/happy_path/teste17_function.out
@echo Rodando o teste 18
java Meuphoria < ./test_cases/happy_path/teste18_our_function.in > ./test_cases/resultados/happy_path/teste18_our_function.out
@echo Rodando o teste 19


java Meuphoria < ./test_cases/sad_path/teste01_variavel_acentuada.in > ./test_cases/resultados/sad_path/teste01_variavel_acentuada.out
@echo Rodando o teste 20
java Meuphoria < ./test_cases/sad_path/teste02_caractere_especial_1.in > ./test_cases/resultados/sad_path/teste02_caractere_especial_1.out
@echo Rodando o teste 21
java Meuphoria < ./test_cases/sad_path/teste03_caractere_especial_2.in > ./test_cases/resultados/sad_path/teste03_caractere_especial_2.out
@echo Rodando o teste 22
java Meuphoria < ./test_cases/sad_path/teste04_caractere_especial_3.in > ./test_cases/resultados/sad_path/teste04_caractere_especial_3.out
@echo Rodando o teste 23
java Meuphoria < ./test_cases/sad_path/teste05_numero_variavel.in > ./test_cases/resultados/sad_path/teste05_numero_variavel.out
@echo Rodando o teste 24
java Meuphoria < ./test_cases/sad_path/teste06_comentario_bloco_aberto.in > ./test_cases/resultados/sad_path/teste06_comentario_bloco_aberto.out
@echo Rodando o teste 25
java Meuphoria < ./test_cases/sad_path/teste07_variavel_30_char.in > ./test_cases/resultados/sad_path/teste07_variavel_30_char.out
@echo Rodando o teste 26
java Meuphoria < ./test_cases/sad_path/teste08_variavel_30_char_2.in > ./test_cases/resultados/sad_path/teste08_variavel_30_char_2.out
@echo Rodando o teste 27
@echo.
@echo OS RESULTADOS DOS TESTES SE ENCONTRAM NA PASTA RESULTADOS
@echo.
@echo.
PAUSE