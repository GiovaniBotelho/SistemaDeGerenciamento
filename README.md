# SistemaDeGerenciamento

# Objetivo do projeto:

1. O sistema deve ter um gerenciamento dos cargos, cadastrando apenas o
nome que é obrigatório e único de cada cargo. Devem haver as opções
de editar um cargo, listar os cargos em ordem alfabética (opcional).

2. O sistema deve ter um gerenciamento de perfis de usuário, cadastrando
apenas o ​ nome que é obrigatório e único de cada perfil. Devem conter as
opções de editar um perfil, listar os perfis em ordem alfabética e
remover um perfil caso o mesmo não tenha nenhum usuário vinculado.

3. O sistema deve cadastrar os usuários com os seguintes campos e
validações: ​ nome (obrigatório), ​ cpf (obrigatório único), ​ dataNascimento​,
sexo (M ou F), ​ cargo (obrigatório) e uma lista de ​ perfis de usuário. Ao
salvar o sistema deve armazenar também a data de cadastro do usuário.
Deve haver a opção de editar um usuário seguindo as mesmas regras de
validação.

4. O usuário deve compartilhar atributos de pessoas, ou seja deve
implementar uma classe pessoa que seja abstrata, e contém os
seguintes atributos: ​ nome​ , c
pf, dataNascimento​ e ​ sexo.

# Banco de dados utilizado

![Banco de dados utlizado no projeto](https://github.com/GiovaniBotelho/SistemaDeGerenciamento/blob/master/dBsistemaGerenciaDeUsuarios.png)

# Detalhes importates

Não foi possível conectar com o banco de dados embora estando no servidor local, por isso, o funcionamento não é garantido. Foram feitas todas as alterações ao meu alcance, mas sem sucesso. No entanto, tentei alcançar o máximo possível dos requisitos propostos para realização do projeto.

O projeto foi feito utilizando o NetBeans IDE. 
Todas as classes estão feitas como as regras propostas. 
O projeto segue uma arquitetura MVC para organizar o frontend e o backend

# Pré-requisitos

Instalação do MySql, da JVM (Java Virtual Machine) com JDK.
