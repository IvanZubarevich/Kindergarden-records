# Требования к приложению


# [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)Содержание

1.  [Введение](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#introduction)

    1.1.  [Назначение](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#appointment)  
    1.2.  [Бизнес-требования](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#business_requirement)  
    1.2.1.  [Исходные данные](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#initial_data)  
    1.2.2.  [Бизнес-цели](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#business_goals)  
    1.2.3.  [Границы проекта](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#project_boundaries)  
    1.3  [Аналоги](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#analogues)

3.  [Пользовательские требования](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.mdd#users_requirements)  
    2.1.  [Программные интерфейсы](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#software_interfaces)  
    2.2.  [Интерфейс пользователя](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#user_interface)  
    2.3.  [Характеристики пользователей](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#user_characteristics)  
    2.3.1.  [Классы пользователей](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#user_classes)  
    2.3.2.  [Аудитория приложения](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#application_audience)

4.  [Системные требования](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#system_requirements)  
    3.1.  [Функциональные требования](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#functional_requirements)  
    3.2.  [Нефункциональные требования](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#non-functional_requirements)  
    3.2.1.  [Атрибуты качества](https://github.com/belarus01/Messenger/blob/master/docs/Requirements/Requirements.md#quality_attributes)  


----------

# [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md#introduction)1. Введение

## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)1.1. Назначение

В данном документе описываются бизнесс-требования, функциональные и нефункциональные требования к Web-приложению «Kindergardens». Этот документ предназначен для команды, которая будет реализовывать и проверять корректность работы данного приложения.

## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)1.2 Бизнес-требования

### [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)1.2.1 Исходные данные
Жизнь многих семей не обходится без появления на свет детей. С течением времени дети идут в соответствующие их возрасту учреждения образования. Одним из таких учреждений является детский сад. Поэтому данная разработка будет полезна для родителей, которые ищут подходящий детский сад для своего ребенка.

### [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)1.2.2 Возможности бизнеса

**«Kindergardens»**  поможет родителям ознакомиться с любым детским садом, а администраторам детских садов опубликовать информацию о их учреждении.

### [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)1.2.3 Границы проекта

Приложение «Kindergardens» позволит авторизованным как клиент пользователям просматривать информацию о детских садах (количество групп, количество свободных мест в группах). Пользователи, авторизованные как администраторы, получат возможность корректировать необходимые данные.


## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)1.3 Аналоги

В ходе анализа существующих программных аналогов было выяснено, что нет приложений, объединяющих в себе все функции, представленные в данном проекте.

----------

# [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)2. Пользовательские требования

## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)2.1. Программные интерфейсы

Приложение предназначено для работы в сети Интернет, написано на языке Java с помощью фреймворка Spring Boot. 

## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)2.2. Интерфейс пользователя

Графический интерфейс пользователя представлен в виде mock-up иллюстраций.


Стартовая страница

![start](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/mockups/Page1.png)

Страница регистрации

![registration](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/mockups/Registration.png)

Страница авторизации

![autarization](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/mockups/Login.png)

Страница администратора

![menu](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/mockups/Page3.png)

Страница пользователя

![main_page](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/mockups/Page2.png)


## 2.3. Характеристики пользователей

### 2.3.1. Классы пользователей
| Класс пользователей |Описание  |
|--|--|
|Администратор|Пользователи, которые прошли процедуру регистрации. Имеют доступ к полному функционалу приложения.|
|Пользователь|Пользователи, которые не прошли процедуру регистрации. Имеют доступ к ограниченному функционалу приложения|

### 2.3.2. Аудитория приложения

Целевой аудиторией проекта являются люди, у которых есть дети, а также руководители детских садов.




# 3. Системные требования

## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)3.1. Функциональные требования

1.  Вход администратора в приложение

**Описание.**
Администратор имеет возможность использовать приложение войдя в свою учётную запись.

|Функция|Требования  |
|--|--|
| Регистрация | Приложение должно запросить у администратора ввести необходимые данные для создания учётной записи. Пользователь должен либо ввести данные, либо отменить действие и авторизоваться. |
|Авторизация|Приложение должно предоставить возможность ввода логина и пароля.|


2.  Изменение данных администратором

**Описание.** Администратор имеет возможность редактировать информацию о детских садах.

|Функция  | Требования |
|--|--|
|Редактирование информации|Приложение должно предоставить  администратору возможность редактировать необходимую информацию.|

3.  Выход администратора из учётной записи

| Функция |Требования  |
|--|--|
|Выход из учётной записи| Приложение должно предоставить администратору возможность выйти из учётной записи с возвратом к окну входа в приложение. |

4. Просмотр информации пользователем

|Функция|Требования|
|--|--|
|Просмотр информации|Приложение должно предоставить возможность пользователю просматривать информацию о детских садах.|


## [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)3.2. Нефункциональные требования

### [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)3.2.1. Атрибуты качества

#### [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)3.2.1.1 Удобство и простота использвания

-   Приложение должно иметь интуитивно понятную навигацию между всеми страницами.
-   Приложение должно иметь интуитивно понятный интерфейс.
-   Доступ к основным функциям приложения не более чем за три операции.

#### [](https://github.com/IvanZubarevich/Kindergarden-records/blob/main/docs/SRS.md)3.2.1.2 Безопасность

Приложение должно хранить данные пользователя в базе данных под управлением СУБД MySql. Доступ к базе данных должно иметь только это приложение.
Приложение предоставляет возможность редактирования информации только администратору.
