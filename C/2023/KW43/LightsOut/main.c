#include <stdlib.h>
#include <stdbool.h>
#include <windows.h>

#define COLS 5
#define ROWS 5

#define WINDOW_WIDTH 500
#define WINDOW_HEIGHT 500

bool board[ROWS][COLS];

const char g_szClassName[] = "myWindowClass";

void PaintWindow(HWND hwnd)
{
  PAINTSTRUCT ps;
  HDC hdc = BeginPaint(hwnd, &ps);
  HPEN hPenOld = SelectObject(hdc, GetStockObject(DC_PEN));
  HBRUSH hBrushOld = SelectObject(hdc, GetStockObject(DC_BRUSH));

  RECT rect;
  GetClientRect(hwnd, &rect);

  int width = rect.right - rect.left;
  int height = rect.bottom - rect.top;

  int cellWidth = width / COLS;
  int cellHeight = height / ROWS;

  for (size_t y = 0; y < ROWS; y++)
  {
    for (size_t x = 0; x < COLS; x++)
    {
      RECT cellRect;
      cellRect.left = x * cellWidth;
      cellRect.top = y * cellHeight;
      cellRect.right = cellRect.left + cellWidth;
      cellRect.bottom = cellRect.top + cellHeight;

      bool isOn = board[y][x];

      SetDCPenColor(hdc, RGB(0, 0, 0));
      if (isOn)
        SetDCBrushColor(hdc, RGB(0, 255, 0));
      else
        SetDCBrushColor(hdc, RGB(0, 120, 0));

      Rectangle(hdc, cellRect.left, cellRect.top, cellRect.right, cellRect.bottom);
    }
  }

  SelectObject(hdc, hPenOld);
  SelectObject(hdc, hBrushOld);
  EndPaint(hwnd, &ps);
}

void HandleLMouseClick(HWND hwnd, POINT pt)
{
  RECT rect;
  GetClientRect(hwnd, &rect);

  int width = rect.right - rect.left;
  int height = rect.bottom - rect.top;

  int cellWidth = width / COLS;
  int cellHeight = height / ROWS;

  int x = pt.x / cellWidth;
  int y = pt.y / cellHeight;

  board[y][x] = !board[y][x];
  if (x > 0)
    board[y][x - 1] = !board[y][x - 1];
  if (x < COLS - 1)
    board[y][x + 1] = !board[y][x + 1];
  if (y > 0)
    board[y - 1][x] = !board[y - 1][x];
  if (y < ROWS - 1)
    board[y + 1][x] = !board[y + 1][x];

  InvalidateRect(hwnd, NULL, true);
}

void RandomizeBoard()
{
  for (size_t y = 0; y < ROWS; y++)
    for (size_t x = 0; x < COLS; x++)
      board[y][x] = rand() % 2 == 0;
}

// Step 4: the Window Procedure
LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
  switch (msg)
  {
  case WM_CREATE:
    HMENU hMenu, hSubMenu;

    hMenu = CreateMenu();
    AppendMenu(hMenu, MF_STRING, 1, "&Randomize");

    SetMenu(hwnd, hMenu);

    break;
  case WM_COMMAND:
    switch (LOWORD(wParam))
    {
    case 1:
      RandomizeBoard();
      InvalidateRect(hwnd, NULL, true);
      break;
    }
    break;
  case WM_SIZE:
    InvalidateRect(hwnd, NULL, true);
    break;
  case WM_PAINT:
    PaintWindow(hwnd);
    break;
  case WM_LBUTTONDOWN:
    // get the mouse position
    POINT pt;
    pt.x = LOWORD(lParam);
    pt.y = HIWORD(lParam);

    HandleLMouseClick(hwnd, pt);
    break;
  case WM_CLOSE:
    DestroyWindow(hwnd);
    break;
  case WM_DESTROY:
    PostQuitMessage(0);
    break;
  default:
    return DefWindowProc(hwnd, msg, wParam, lParam);
  }
  return 0;
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
  WNDCLASSEX wc;
  HWND hwnd;
  MSG Msg;

  // Step 1: Registering the Window Class
  wc.cbSize = sizeof(WNDCLASSEX);
  wc.style = 0;
  wc.lpfnWndProc = WndProc;
  wc.cbClsExtra = 0;
  wc.cbWndExtra = 0;
  wc.hInstance = hInstance;
  wc.hIcon = LoadIcon(NULL, IDI_APPLICATION);
  wc.hCursor = LoadCursor(NULL, IDC_ARROW);
  // wc.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);
  wc.lpszMenuName = NULL;
  wc.lpszClassName = g_szClassName;
  wc.hIconSm = LoadIcon(NULL, IDI_APPLICATION);

  if (!RegisterClassEx(&wc))
  {
    MessageBox(NULL, "Window Registration Failed!", "Error!", MB_ICONEXCLAMATION | MB_OK);
    return 0;
  }

  // Step 2: Creating the Window
  hwnd = CreateWindowEx(
      WS_EX_CLIENTEDGE,
      g_szClassName,
      "Lights Out",
      WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, CW_USEDEFAULT,
      WINDOW_WIDTH, WINDOW_WIDTH,
      NULL, NULL, hInstance, NULL);

  if (hwnd == NULL)
  {
    MessageBox(NULL, "Window Creation Failed!", "Error!", MB_ICONEXCLAMATION | MB_OK);
    return 0;
  }

  RandomizeBoard();

  ShowWindow(hwnd, nCmdShow);
  UpdateWindow(hwnd);

  // Step 3: The Message Loop
  while (GetMessage(&Msg, NULL, 0, 0) > 0)
  {
    TranslateMessage(&Msg);
    DispatchMessage(&Msg);
  }
  return Msg.wParam;
}
