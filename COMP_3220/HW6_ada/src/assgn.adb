-- Author(s): Kevin Bumgarner & Dr. Sardinas
-- Date: 04/15/2021
-- Class: COMP 3220

with Ada.Numerics.Discrete_Random;

with Ada.Text_IO, Ada.Float_Text_IO, Ada.Integer_Text_IO, Assgn;
use Ada.Text_IO, Ada.Float_Text_IO, Ada.Integer_Text_IO, Assgn;

package body Assgn is 
   
   --initialize first array (My_Array) with random binary values----------------
   procedure Init_Array (Arr: in out BINARY_ARRAY) is      
      package Random_Bit is new Ada.Numerics.Discrete_Random (BINARY_NUMBER);
      use Random_Bit;
      Gen : Generator;   
   begin
      Reset (Gen);
      for Index in 1..16 loop
         Arr(Index) := Random(Gen); 
      end loop;      
   end Init_Array;
   
   --reverse binary array-------------------------------------------------------
   procedure Reverse_Bin_Arr (Arr : in out BINARY_ARRAY) is    
      ReversedArr : BINARY_ARRAY;
      Pos : Integer := 1;
   begin      
      for Index in reverse 1..16 loop
         ReversedArr(Index) := Arr(Pos);
         Pos := Pos + 1;
      end loop;       
      Arr := ReversedArr;      
   end Reverse_Bin_Arr;
   
   --print an array-------------------------------------------------------------
   procedure Print_Bin_Arr (Arr : in BINARY_ARRAY) is   
   begin      
      for Index in 1..16 loop
         Put(String(Integer'Image(Integer(Arr(Index)))));         
      end loop;
      New_Line(2);      
   end Print_Bin_Arr;
     
   --Convert Integer to Binary Array--------------------------------------------
   function Int_To_Bin(Num : in INTEGER) return BINARY_ARRAY is   
      ResultArr : BINARY_ARRAY;
      Dividend : Integer := Num;
      Remainder : Integer := Num;   
   begin
      for Index in reverse 1..16 loop    
         if Dividend = 0 then         
            ResultArr(Index) := 0;
         else            
            Remainder := Dividend rem 2;
            ResultArr(Index) := Remainder;
            Dividend := Dividend / 2;            
         end if;  
      end loop;    
      return ResultArr;
   end Int_To_Bin;
   
      --convert binary number to integer----------------------------------------
   function Bin_To_Int (Arr : in BINARY_ARRAY) return INTEGER is 
      Result : Integer := 0;
      Pos : Integer := 15;
   begin 
      for Index in 1..16 loop 
         Result := Result + (Arr(Index) * (2**(Pos)));
         Pos := Pos - 1;
      end loop;      
      return Result;        
   end Bin_To_Int;
   
      --overloaded + operator to add two BINARY_ARRAY types together------------
   function "+" (Left, Right : in BINARY_ARRAY) return BINARY_ARRAY is      
      Sum : BINARY_ARRAY;
      Carry : BINARY_NUMBER := 0;      
   begin    
      for Index in reverse 1..16 loop
         if Carry <= 0 then 
            if Left(Index) = 0 and Right(Index) = 0 then
               Sum(Index) := 0;     
            elsif Left(Index) = 1 and Right(Index) = 1 then
               Sum(Index) := 0;
               Carry := 1;
            else
               Sum(Index) := 1;
            end if;                                                   
         elsif Carry > 0 then
            if Left(Index) = 0 and Right(Index) = 0 then
               Sum(Index) := 1; 
               Carry := 0;
            elsif Left(Index) = 1 and Right(Index) = 1 then
               Sum(Index) := 1;
            else
               Sum(Index) := 0;
            end if;
         else 
            Put("What happened to Carry? He looks large.");
         end if;
      end loop;        
      return Sum;    
   end "+";
   
   --overloaded + operator to add an INTEGER type and a BINARY_ARRAY type together
   function "+" (Left : in INTEGER; Right : in BINARY_ARRAY) return BINARY_ARRAY is 
      Sum : BINARY_ARRAY;
      LeftBit: BINARY_ARRAY;
   begin      
      LeftBit := Int_To_Bin(Left);
      Sum := LeftBit + Right;    
      return Sum;
   end "+";
   
   --overloaded - operator to subtract one BINARY_ARRAY type from another-------			 
   function "-" (Left, Right : in BINARY_ARRAY) return BINARY_ARRAY is 
      Diff : BINARY_ARRAY;
      NonZeroFound : Boolean := False;
      TwosCompRight : BINARY_ARRAY;
   begin
      for Index in reverse 1..16 loop
         if Right(Index) = 0 then
            if NonZeroFound = False then
               TwosCompRight(Index) := 0;
            else 
               TwosCompRight(Index) := 1;
            end if;
         else
            if NonZeroFound = False then
               TwosCompRight(Index) := 1;
               NonZeroFound := True;
            else 
               TwosCompRight(Index) := 0;
            end if;            
         end if;
      end loop;      
      Diff := Left + TwosCompRight;      
      return Diff;
   end "-";
   
   --overloaded - operator to subtract a BINARY_ARRAY type from an INTEGER type-
   function "-" (Left : in Integer; Right : in BINARY_ARRAY) return BINARY_ARRAY is
      Diff : BINARY_ARRAY;
      LeftBit: BINARY_ARRAY;
   begin      
      LeftBit := Int_To_Bin(Left);
      Diff := LeftBit - Right;      
      return Diff;
   end "-";   

end Assgn;
