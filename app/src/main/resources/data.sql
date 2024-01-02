INSERT INTO public.groups(id, name) VALUES (1, 'public');
INSERT INTO public.groups(id, name) VALUES (2, 'premium');
INSERT INTO public.groups(id, name) VALUES (3, 'admin');
INSERT INTO public.articles(id, text, group_id, title, created, published, description, image, lang) VALUES (1, '<p>test</p>', 1, 'article1', '2020-12-21 22:24:18.48502', false, 'test article', 'https://i.ytimg.com/vi/92J-JPChaeI/maxresdefault.jpg', 'us') ON CONFLICT DO NOTHING;