---
title: Java Funcional - Boas Praticas
author: Diogo Fávero Fabrile.
patat:
    wrap: true
    margins:
        left: 10
        right: 10
...

~~~~~~~
   ___                     ___           _   _                          __                       ___                 _                   _ 
  / __\ ___   __ _ ___    / _ \_ __ __ _| |_(_) ___ __ _ ___            \ \  __ ___   ____ _    / __\   _ _ __   ___(_) ___  _ __   __ _| |
 /__\/// _ \ / _` / __|  / /_)/ '__/ _` | __| |/ __/ _` / __|  _____     \ \/ _` \ \ / / _` |  / _\| | | | '_ \ / __| |/ _ \| '_ \ / _` | |
/ \/  \ (_) | (_| \__ \ / ___/| | | (_| | |_| | (_| (_| \__ \ |_____| /\_/ / (_| |\ V / (_| | / /  | |_| | | | | (__| | (_) | | | | (_| | |
\_____/\___/ \__,_|___/ \/    |_|  \__,_|\__|_|\___\__,_|___/         \___/ \__,_| \_/ \__,_| \/    \__,_|_| |_|\___|_|\___/|_| |_|\__,_|_|
~~~~~~~


        

---

# Objetivo do Curso

##O que este curso não é?

* Não é um curso para aprender os conceitos basicos de streams, lambda e programação funcional

##O que esperar deste curso?

* Demonstrar boas práticas na utilização do paradigma funcional através de exemplos e comparações. 


---

#Apresentação Pessoal

_Diogo Favero Fabrile_

* Experiência profissional 
    + 9 Anos de Experiência
        + Pequenas Empresas
        + Médias  Empresa
        + Grandes Empresas
        + Experiência no exterior (EUA & Belgica & Alemanha )        
        
* Certificações
    + OCJP 6(Oracle Certified Java Programmer)
    + OCEJWCD 6(Oracle Certified Web Component Developer Certified Expert)
    + OCEEJBD 6(Oracle Certified Enterprise JavaBeans Developer Expert)
    + OCEJPAD 6(Oracle Certified Java Persistence API Developer)
    + OCEJWSD 6(Oracle Certified Java Web Service Developer)
    + IBM Cloud V1

    
---

# Apresentação do curso

* 01-**Introdução do curso**
    + [ ] _Objetivo do curso e pré-requisitos_
* 02-Mude sua forma de pensar.
    + [ ] _02.1-Imperativo vs Declarativo_
    + [ ] _02.2-Vantagens de se programar orientado a funções._
    + [ ] _02.3-POO acabou?_
* 03-Teoria na pratica (comparando Imperativo e Declarativo)
    + [ ] _03.1-Iteração simplificada(evitando side effects)_
    + [ ] _03.2-Mapeando nosso objeto (Imutabilidade)_
    + [ ] _03.3-Localizando elementos nas nossas coleções(Entendendo Lazy Evaluation)_
    + [ ] _03.4-Reutilizando as nossas funções_
    + [ ] _03.5-Escopo lexico(estático) e como utilizar_
    + [ ] _03.6-Reduzindo nossas coleções Map Reduce (Contanto uma historia)_
* 04-Evolução das API's
    + [ ] _04.1-Files, Novas formas de utilizar_
    + [ ] _04.2-Collectors, como coletar nossos objetos_
    + [ ] _04.3-Comparators, como comparar os seus objetos_
* 05-Criando suas API's utilizando lambda
    + [ ] _05.1-Por que temos os métodos default?_
    + [ ] _05.2-Codigo conciso (strategy pattern e lambdas)_
    + [ ] _05.3-Builder nas suas funções_
    + [ ] _05.4-O que fazemos com as exceptions?_
    + [ ] _05.5-Lidando com Resources_
* 06-Seja Preguiçoso
    + [ ] _06.1-Procrastine até a última hora_
    + [ ]   _06.2-Lazy evaluation e streams infinitas_    
* 07-Paralelização de algoritimos
    + [ ] _07.1-Como utilizar a paralelização_
    + [ ] _07.2-Cuidados com a paralelização_
+ 08-Dicas Finais
    + [ ] _08.1-Lambdas e Method reference qual utilizar e porque?_
    + [ ] _08.2-Prefira as funções que ja estão presentes no java_
    + [ ] _08.3-Não abuse das streams_
    + [ ] _08.4-Otimização Tail Call_
    + [ ] _08.5-Considerações finais_
    
    
---

---

#Outras considerações

#Inglês e Português

Termos e variaveis misturando um pouco de inglês e português. 

#Slides

Apresentação utilizando o **patat**. Aplicação para slides no terminal.

https://github.com/jaspervdj/patat

#IDE

Intellij IDEA


---

~~~~~

             ________________________________________________
            /                                                \
           |    _________________________________________     |
           |   |                                         |    |
           |   |  C:\> See You soon!!                    |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |                                         |    |
           |   |_________________________________________|    |
           |                                                  |
            \_________________________________________________/
                   \___________________________________/
                ___________________________________________
             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_
          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_
       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_
    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_
 _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_
:-------------------------------------------------------------------------:
`---._.-------------------------------------------------------------._.---'
                              


~~~~~

---