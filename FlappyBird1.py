## Flappy Bird

import pygame as pg
import os
import random

pg.init()

clock = pg.time.Clock()
FPS = 60

SCREEN_WIDTH = 648
SCREEN_HEIGHT = 702 #ground at 576

FONT = pg.font.SysFont('Bauhas 93', 60)

WHITE = (255,255,255)

screen = pg.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pg.display.set_caption('Flappy Bird')

#load images
BG = pg.image.load(os.path.join('Assets', 'bg.png'))
GROUND = pg.image.load(os.path.join('Assets','ground.png'))
BUTTON = pg.image.load(os.path.join('Assets','restart.png'))

def draw_text(text, font, text_color, x, y):
    img = font.render(text, True, text_color)
    screen.blit(img, (x,y))

def reset_game():
    pipe_group.empty()
    flappy.rect.x = 100
    flappy.rect.y = int(SCREEN_HEIGHT/2)
    score = 0
    return score


#ground variable
ground_scroll = 0
scroll_speed = 4
flying = False
game_over = False
pipe_gap = 200
pipe_frequency = 1500 #milliseconds
last_pipe = pg.time.get_ticks()
score = 0
pass_pipe = False


class Bird(pg.sprite.Sprite):
    def __init__(self, x, y):
        pg.sprite.Sprite.__init__(self)
        self.images = []
        self.index = 0
        self.counter = 0
        for num in range(1, 4):
            img = pg.image.load(os.path.join('Assets',f'bird{num}.png'))
            self.images.append(img)
        self.image = self.images[self.index]
        self.rect = self.image.get_rect()
        self.rect.center = [x, y]
        self.vel = 0
        self.clicked = False
    
    def update(self):

        if flying == True:
        #gravity
            self.vel += 0.5
            if self.vel > 4:
                self.vel = 4
            if self.rect.bottom < 576:
                self.rect.y += int(self.vel)

        if game_over == False:
            #jump
            if pg.mouse.get_pressed()[0] == 1: #and self.clicked == False:
                self.clicked = True
                self.vel = -6
            if pg.mouse.get_pressed()[0] == 0:
                self.clicked = False

            #handle animation
            self.counter += 1
            flap_cooldown = 5

            if self.counter > flap_cooldown:
                self.counter = 0
                self.index += 1
                if self.index >= len(self.images):
                    self.index = 0
            self.image = self.images[self.index]

            #rotate the bird
            self.image = pg.transform.rotate(self.images[self.index], self.vel * -2)
        else:
            self.image = pg.transform.rotate(self.images[self.index], -90)


class Pipe(pg.sprite.Sprite):
    def __init__(self, x, y, position):
        pg.sprite.Sprite.__init__(self)
        self.image = pg.image.load(os.path.join('Assets','pipe.png'))
        self.rect = self.image.get_rect()
        #position 1 from top, -1 from bottom
        if position == 1:
            self.image = pg.transform.flip(self.image, False, True)
            self.rect.bottomleft = [x,y - int(pipe_gap /2)]
        if position == -1:
            self.rect.topleft = [x,y + int(pipe_gap / 2)]

    def update(self):
        self.rect.x -= scroll_speed
        if self.rect.right <  0:
            self.kill()


class Button():
    def __init__(self, x, y, image):
        self.image = image
        self.rect = self.image.get_rect()
        self.rect.topleft = (x, y)

    def draw(self):

        action = False

        # get mouse position
        pos = pg.mouse.get_pos()

        #check if mouse is over button
        if self.rect.collidepoint(pos):
            if pg.mouse.get_pressed()[0] == 1:
                action = True

        #draw button
        screen.blit(self.image, (self.rect.x, self.rect.y))

        return action

bird_group = pg.sprite.Group()
pipe_group = pg.sprite.Group()

flappy = Bird(100, int(SCREEN_HEIGHT/2))

bird_group.add(flappy)

#restart button
button = Button(SCREEN_WIDTH // 2- 50, SCREEN_HEIGHT // 2 - 100, BUTTON)

run = True
while run:
    clock.tick(FPS)

    # BG
    screen.blit(BG, (0,0))

    bird_group.draw(screen)
    bird_group.update()
    pipe_group.draw(screen)


    #draw the ground
    screen.blit(GROUND,(ground_scroll,576))

    #checking score
    if len(pipe_group) > 0:
        if bird_group.sprites()[0].rect.left > pipe_group.sprites()[0].rect.left and bird_group.sprites()[0].rect.right < pipe_group.sprites()[0].rect.right and pass_pipe == False:
                pass_pipe = True
        if pass_pipe == True:
            if bird_group.sprites()[0].rect.left >pipe_group.sprites()[0].rect.right:
                score += 1
                pass_pipe = False 

    draw_text(str(score), FONT, WHITE, int(SCREEN_WIDTH/2), 20)

    #look for collision
    if pg.sprite.groupcollide(bird_group, pipe_group, False, False) or flappy.rect.top < 0:
        game_over = True

    #check bird collision w/ground
    if flappy.rect.bottom >= 576:
        game_over = True
        flying = False

    if game_over == False and flying == True:
    #Generate New pipes
        time_now = pg.time.get_ticks()
        if time_now - last_pipe > pipe_frequency:
            pipe_height = random.randint(-100, 100)
            btm_pipe = Pipe(SCREEN_WIDTH, int(SCREEN_HEIGHT/2) + pipe_height, -1)
            top_pipe = Pipe(SCREEN_WIDTH, int(SCREEN_HEIGHT/2) + pipe_height, 1)
            pipe_group.add(btm_pipe)
            pipe_group.add(top_pipe)
            last_pipe = time_now

    #Ground Scroll
        ground_scroll -= scroll_speed
        if abs(ground_scroll) > 35:
            ground_scroll = 0

        pipe_group.update()

    #check for game over and reset
    if game_over == True:
        if button.draw() == True:
            game_over = False
            score = reset_game()

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False
        if event.type == pg.MOUSEBUTTONDOWN and flying == False and game_over == False:
            flying = True

    pg.display.update()

pg.quit()