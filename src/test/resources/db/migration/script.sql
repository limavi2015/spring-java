--CREATE USER postgres WITH ENCRYPTED PASSWORD 'mysecretpassword' NOCREATEDB;
--CREATE DATABASE public WITH OWNER postgres;

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

