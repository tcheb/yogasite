CREATE TABLE public.articles
(
    text text COLLATE pg_catalog."default" NOT NULL,
    group_id bigint NOT NULL,
    id bigint NOT NULL DEFAULT nextval('articles_id_seq'::regclass),
    title character varying COLLATE pg_catalog."default",
    created timestamp without time zone NOT NULL DEFAULT timezone('utc'::text, now()),
    published boolean NOT NULL DEFAULT false,
    description character varying COLLATE pg_catalog."default",
    image character varying COLLATE pg_catalog."default",
    lang character varying COLLATE pg_catalog."default" NOT NULL DEFAULT 'us'::character varying,
    CONSTRAINT articles_pkey PRIMARY KEY (id)
)

CREATE TABLE public.groups
(
    id bigint NOT NULL DEFAULT nextval('group_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT group_pkey PRIMARY KEY (id)
)

CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    group_id bigint,
    email character varying COLLATE pg_catalog."default",
    firstname character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default",
    username character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

ALTER TABLE public.groups
    OWNER to postgres;

ALTER TABLE public.articles
    OWNER to postgres;

