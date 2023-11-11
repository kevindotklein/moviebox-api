INSERT INTO public.medias (id, name, cover, description, genre, director, year)
    VALUES
        ('8e640746-18f7-4bf0-9892-250182ff47ba', 'ai vc malou ratao serie',
         'https://i.pinimg.com/236x/c4/7d/39/c47d392c9de27b845a954346f604cd5d.jpg', 'malou serie',
         'ROMANCE', 'ratao', '2024'),
        ('3347f648-2f64-444c-91a2-d30c72639a15', 'ai vc malou ratao spinoff',
         'https://i.pinimg.com/236x/c4/7d/39/c47d392c9de27b845a954346f604cd5d.jpg', 'malou spinoff',
         'HORROR', 'ratao', '2024');

INSERT INTO public.series (id, episodes, seasons) VALUES ('8e640746-18f7-4bf0-9892-250182ff47ba', '8', '1');
INSERT INTO public.series (id, episodes, seasons) VALUES ('3347f648-2f64-444c-91a2-d30c72639a15', '8', '1');