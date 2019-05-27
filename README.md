# Services with spring-java 

REST services to get and store information in a Postgres database.


### 1. Required database to run the service

For this exercise we use a postgres container
   
    > docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres

Then, execute the next script
    
```
CREATE TABLE IF NOT EXISTS public.productos
(
   identificador             	text,
   nombre_producto             	text,
   valor                       	text,
   CONSTRAINT pk_producto PRIMARY KEY (identificador)
);
insert into public.productos values ('1','galletas', 2000);
insert into public.productos values ('2','chocolate', 6000);
insert into public.productos values ('3','queso', 5000);
insert into public.productos values ('4','pan', 1000);
```    

If you want more information, check the next link [Docker of Postgres](https://docs.docker.com/samples/library/postgres/)    


### 2. REST services

*  GET  
> *http://localhost:8090/api/v1/products*

*  POST 
> *http://localhost:8090/api/v1/products*
  
```
{
    "id": "5",
    "name": "jamon",
    "value": 800
}
```