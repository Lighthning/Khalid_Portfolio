#Khalid Yaseen Baig
#102763240

require 'rubygems'
require 'gosu'

SCREEN_WIDTH = 1200
SCREEN_HEIGHT = 800

module ZOrder
  BACKGROUND, MIDDLE, TOP = *0..2
end

#The game main menu
class Menu < Gosu::Window
	
	def initialize
		super 500, 550
		self.caption = "Rock Paper Scissor Game"
		@locs = Array.new(2)
		@logo = Gosu::Image.new("rps.jpg")
		@background = Gosu::Image.new("background1.jpg")

	end
	
	def needs_cursor?
		true
	end
	
	def draw_background
		@background.draw(0, 0,	 ZOrder::BACKGROUND, scale_x = 1.0, scale_y = 1.0)
		
	end
	
	def draw_text
		Gosu::Font.new(20).draw_text("ROCK-PAPER-SCISSOR", 50, 40, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		Gosu::Font.new(20).draw_text("GAME", 200, 72, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		Gosu::Font.new(18).draw_text("START", 200, 395, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		Gosu::Font.new(18).draw_text("EXIT", 215, 465, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)	
		
	end
	
	def draw_image
		@logo.draw(120, 130 , ZOrder::MIDDLE, scale_x = 0.5, scale_y = 0.5)
	end
	
	def draw_button
		Gosu.draw_rect(125, 380, 245, 60, Gosu::Color::BLACK, ZOrder::MIDDLE)
		Gosu.draw_rect(125, 450, 245, 60, Gosu::Color::BLACK, ZOrder::MIDDLE)
		
	end
	
	def draw
		draw_background
		draw_text
		draw_image
		draw_button
		@locs = [mouse_x, mouse_y]

	end
	
	def area_clicked(lx, ty, rx, by)
		if (@locs[0] > lx and @locs[1] > ty and @locs[0] < rx and @locs[1] < by)
			return true
		else
			return false
		end	
	end
	
	def button_down(id)
		case id
		when Gosu::MsLeft
			@locs[0] = mouse_x
			@locs[1] = mouse_y
			
			if area_clicked(125, 380, 370,440)
				close
				GameScreen.new.show
			
			end
			if area_clicked(125, 450, 370,510)
				close
			
			end
		end
	end
end

#The main game window
class GameScreen < Gosu::Window

	def initialize
		super(1200, 900, false)
		self.caption = "RPS GAME"
		@background = Gosu::Image.new("background1.jpg")
		@locs = Array.new(2)
		@score1 = 0
		@score2 = 0
		@rock = Gosu::Image.new("b1.jpg")
		@paper= Gosu::Image.new("b2.jpg")
		@scissor = Gosu::Image.new("b3.jpg")
		@rockcomp = Gosu::Image.new("1.jpg")
		@papercomp = Gosu::Image.new("3.jpg")
		@scissorcomp = Gosu::Image.new("2.jpg")
		@rockplayer = Gosu::Image.new("11.jpg")
		@paperplayer = Gosu::Image.new("33.jpg")
		@scissorplayer = Gosu::Image.new("22.jpg")
	end
	
	def draw_background
		@background.draw(0, 0,ZOrder::BACKGROUND, scale_x = 1.0, scale_y = 1.0)
		
	end
	
	def draw_button
		@rock.draw(200,500, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)	
        @paper.draw(500,500, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)	
		@scissor.draw(800,500, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
		
	end
	
	def draw_image
		@rockplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
		@rockcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	end
	
	def draw_text
	     Gosu::Font.new(20).draw_text("Your Score: #{@score1}", 10, 20, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		 Gosu::Font.new(20).draw_text("Computer's Score: #{@score2}", 850, 20, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		 Gosu::Font.new(20).draw_text("PLAYER", 350, 200, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		 Gosu::Font.new(20).draw_text("COMPUTER", 650, 200, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
	end
	
    def	draw_dialougue
	     Gosu::Font.new(20).draw_text("CLICK ON ROCK-PAPER-SCISSOR TO PLAY", 230, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		 Gosu::Font.new(20).draw_text("FIRST TO SCORE 5 POINTS WINS", 310, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
    end
	
	def draw
	    draw_background
		draw_text
		draw_button
		draw_image
        draw_dialougue
		@locs = [mouse_x, mouse_y]
	end
	
	def needs_cursor?
		true
	end
	
	def area_clicked(lx, ty, rx, by)
		if (@locs[0] > lx and @locs[1] > ty and @locs[0] < rx and @locs[1] < by)
			return true
		else
			return false
		end	
	end
	
	def button_down(id)
		case id
		when Gosu::MsLeft
			@locs[0] = mouse_x
			@locs[1] = mouse_y
			#ROCK_WIN
			if area_clicked(200,450, 400,650) && computer == "s"
				@score1 += 1
				def draw_dialougue
				Gosu::Font.new(20).draw_text("YOU CHOSE ROCK & COMPUTER CHOSE SCISSOR", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("ROCK BEATS SCISSOR, YOU WIN THIS ROUND", 200, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image	
		        @rockplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@scissorcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#PAPER_WIN	
		    elsif area_clicked(500,450, 700,650) && computer == "r"
			    @score1 += 1
				def draw_dialougue
				Gosu::Font.new(20).draw_text("YOU CHOSE PAPER & COMPUTER CHOSE ROCK", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("PAPER BEATS ROCK, YOU WIN THIS ROUND.", 200, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image
		        @paperplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@rockcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#SCISSOR_WIN
			elsif area_clicked(800,450, 1000,650) && computer == "p"
			    @score1 += 1
				def draw_dialougue
				Gosu::Font.new(20).draw_text("YOU CHOSE SCISSOR & COMPUTER CHOSE PAPER", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("SCISSOR BEATS PAPER, YOU WIN THIS ROUND.", 190, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image
		        @scissorplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@papercomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#ROCK_LOSS
			elsif area_clicked(200,450, 400,650) && computer == "p"
				@score2 += 1
				def draw_dialougue
				Gosu::Font.new(20).draw_text("YOU CHOSE ROCK & COMPUTER CHOSE PAPER", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("PAPER BEATS ROCK, COMPUTER WINS THIS ROUND.", 140, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image
		        @rockplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@papercomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#PAPER_LOSS	
		    elsif area_clicked(500,450, 700,650)  && computer == "s"
			    @score2 += 1
				def draw_dialougue
				Gosu::Font.new(20).draw_text("YOU CHOSE PAPER & COMPUTER CHOSE SCISSOR", 160, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("SCISSOR BEATS PAPER, COMPUTER WINS THIS ROUND.", 120, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image
		        @paperplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@scissorcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#SCISSOR_LOSS
			elsif area_clicked(800,450, 1000,650) && computer == "r"
			    @score2 += 1
				def draw_dialougue
			    Gosu::Font.new(20).draw_text("YOU CHOSE SCISSOR & COMPUTER CHOSE ROCK", 170, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("ROCK BEATS SCISSOR, COMPUTER WINS THIS ROUND.", 130, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image	
		        @scissorplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@rockcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#ROCK_TIE
             elsif area_clicked(200,450, 400,650) && computer == "r"
				def draw_dialougue	
			    Gosu::Font.new(20).draw_text("YOU CHOSE ROCK & COMPUTER CHOSE ROCK", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("ITS A TIE", 500, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image	
		        @rockplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@rockcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#PAPER_TIE
             elsif area_clicked(500,450, 700,650)  && computer == "p"
				def draw_dialougue
			    Gosu::Font.new(20).draw_text("YOU CHOSE PAPER & COMPUTER CHOSE PAPER", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("ITS A TIE", 500, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end	
				def draw_image	
		        @paperplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@papercomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
			#SCISSOR_TIE
             elsif area_clicked(800,450, 1000,650)  && computer == "S"
				def draw_dialougue			
			    Gosu::Font.new(20).draw_text("YOU CHOSE SCISSORS & COMPUTER SCHOSE SCISSOR", 180, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				Gosu::Font.new(20).draw_text("ITS A TIE", 500, 800, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end
				def draw_image	
		        @scissorplayer.draw(350,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
				@scissorcomp.draw(650,250, ZOrder::MIDDLE, scale_x = 1, scale_y = 1)
	            end
             else
                def draw_dialougue		
			    Gosu::Font.new(20).draw_text("CLICK ON ROCK-PAPER-SCISSOR TO PLAY", 220, 750, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
				end			 
			end
		end
	end
	
	def computer
         comp = rand(3)
         if comp == 0
             comp = "p"
         elsif comp == 1
             comp = "r"
         else
             comp = "s"
         end
     end
	
	def update
		if @score1 ==5
			writescore(@score1)
			close
			Result.new.show
		elsif @score2 ==5
		    writescore(@score1)
			close
			Result.new.show		
		end
	end
	
	def writescore(scores)
		score_file = File.new("scores.txt", "w")
		score_file.puts @score1 
		score_file.close()
	end
end

#Window that display the score of the user
class Result < Gosu::Window

	def initialize
		super(600, 400, false)
		self.caption = "Scoreboard"
		@background = Gosu::Image.new("background2.jpg")
	end

	def needs_cursor?
		true
	end
	
	def readscore
		score_file = File.new("scores.txt", "r")
		@score = score_file.gets.chomp.to_i
		return @score
	end
	
	def draw_text
		readscore
		Gosu::Font.new(18).draw_text("YOUR SCORE: #{@score}", 175, 200, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		Gosu::Font.new(20).draw_text("THIS GAME", 190, 110, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		Gosu::Font.new(15).draw_text("PLAY AGAIN", 92, 315, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		Gosu::Font.new(15).draw_text("MAIN MENU", 347, 315, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		
		if @score == 5
			Gosu::Font.new(20).draw_text("CONGRATS, YOU WIN", 110, 70, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		else
			Gosu::Font.new(20).draw_text("YOU LOSE, COMPUTER WINS", 45, 70, ZOrder::TOP, 2.0, 2.0, Gosu::Color::WHITE)
		end
		
	end
	
	def draw_background
		@background.draw(0, 0,	 ZOrder::BACKGROUND, scale_x = 1.0, scale_y = 1.0)
		
	end
    
    def draw
        draw_button
		draw_text
	    @locs = [mouse_x, mouse_y]
		draw_background
	end

    def draw_button
		Gosu.draw_rect(50, 300, 245, 60, Gosu::Color::BLACK, ZOrder::MIDDLE)
		Gosu.draw_rect(300, 300, 245, 60, Gosu::Color::BLACK, ZOrder::MIDDLE)
	end
	

	
	def area_clicked(lx, ty, rx, by)
		if (@locs[0] > lx and @locs[1] > ty and @locs[0] < rx and @locs[1] < by)
			return true
		else
			return false
		end	
	end
	
	def button_down(id)
		case id
		when Gosu::MsLeft
			@locs[0] = mouse_x
			@locs[1] = mouse_y
			
			if area_clicked(50, 300, 300,360)
				close
				GameScreen.new.show
			end
			
			if area_clicked(300, 300, 545,360)
				close
				Menu.new.show
			
			end
		end
	end
	
	

	
end

Menu.new.show