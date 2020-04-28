클래스 정리

Main 		: 메인 실행
MainFrame	: 프레임. 여기에다가 이제 각 각 패널들을 붙여서 화면 구성
Beat		: 로그인 화면 --> 회원가입과 로그인 기능 있음
SignupPanel : 회원가입 화면
Lobby		: 로그인 실행 시 진입하는 화면  --> Start(곡 선택화면으로), 기록보기, 랭킹보기 있음
Record		: 유저의 기록보는 화면
Ranking		: 랭킹 화면
SelectSong	: 곡 선택 화면(Lobby로 돌아가거나 게임 플레이 화면으로 돌아가는 기능)
GamePlay	: SelectSong에서 곡 타이틀이름과 난이도, 선택한 음악을 받아서 화면 틀 구성
			   결과와 나가기가 있음
Game		: GamePlay에서 곡 타이틀이름과 난이도, 선택한 음악을 받아서 실제 게임 구현(노트, 판정식, 음악재생 등등)

BeatPlay	: 노트가 떨어질 시간과 키 값 저장 클래스. -> 비트라고 생각하면 됨.
MusicBeat	: 각 곡 별로 비트 넣어 줌. 이걸 BeatPlay배열 값으로 리턴 해 줌.
Note		: 노트의 판정식 등을 지정해 줌. BeatPlay에서의 키 값을 가지고 어느 위치에서 떨굴지 결정(스레드)

Ranking		: 랭킹창 화면
ResultScreen: 결과창

Music		: 음악 재생 클래스
Track		: 곡 정보 저장?
KeyListener : 말 그대로 키 리스너..?
GameFinishThread : 음악이 꺼지면 5초간 유지되었다고 종료되는 스레드
				    게임이 종료되는 시점을 맞출 수가 있다.